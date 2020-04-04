package com.vulcan.model.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.Medicine;
import com.vulcan.model.entity.MedicineType;
import com.vulcan.model.mapper.MedicineMapper;
import com.vulcan.model.mapper.MedicineTypeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Allwayz
 * @since 2020-04-04
 */
@Slf4j
@Transactional
@RestController
@RequestMapping("/medicine")
public class MedicineController extends ApiController {
    @Autowired
    private MedicineMapper medicineMapper;
    @Autowired
    private MedicineTypeMapper medicineTypeMapper;

    /**
     * <p>
     *     查找所有药品
     * </p>
     * @return
     */
    @GetMapping()
    public R getMedicine(){
        List<Medicine> medicineList = medicineMapper.selectList(new QueryWrapper<>());
        if(!(medicineList.size() == 0)){
            return success(medicineList);
        }else {
            return success(null);
        }
    }

    /**
     * <p>
     *     根据药品分类查找药品
     * </p>
     * @param medicineTypeName
     * @return
     */
    @GetMapping("{medicineTypeName}")
    public R getMedicineByMedicineType(@PathVariable String medicineTypeName){
        MedicineType medicineType = medicineTypeMapper.selectOne(new QueryWrapper<MedicineType>().eq("medicine_type_name",medicineTypeName));
        List<Medicine> medicineList = medicineMapper.selectList(new QueryWrapper<Medicine>().eq("medicine_type_id",medicineType.getMedicineTypeId()));
        if(!(medicineList.size() == 0)){
            return success(medicineList);
        }else {
            return success(null);
        }
    }

    /**
     * <p>
     *     新建一个药品，如果药品存在，就更执行更新操作
     * </p>
     * @param medicineName
     * @param medicineCode
     * @param status
     * @param count
     * @param medicineTypeName
     * @return
     */
    @PostMapping()
    public R addMedicine(String medicineName,String medicineCode,String status,int count,String medicineTypeName){
        if (!medicineName.isEmpty()||medicineCode.isEmpty()||medicineTypeName.isEmpty()){
            if(!(medicineMapper.selectOne(new QueryWrapper<Medicine>().eq("medicine_name",medicineName)) == null)){
                //TODO: update
                Medicine medicine = medicineMapper.selectOne(new QueryWrapper<Medicine>().eq("medicine_name",medicineName));
                medicine.setMedicineCount(count);
                medicine.setStatus(status);
                return success(medicineMapper.updateById(medicine));
            }
            int medicineTypeId = medicineTypeMapper.selectOne(new QueryWrapper<MedicineType>().eq("medicine_type_name",medicineTypeName)).getMedicineTypeId();
            Medicine medicine = Medicine.builder()
                    .medicineCode(medicineCode)
                    .medicineName(medicineName)
                    .status(status)
                    .medicineCount(count)
                    .medicineTypeId(medicineTypeId)
                    .build();
            return success(medicineMapper.insert(medicine));
        }
        return failed("Empty Field");
    }

    @PutMapping("{medicineName}")
    public R updateMedicine(@PathVariable String medicineName,String status,int count){
        Medicine medicine = medicineMapper.selectOne(new QueryWrapper<Medicine>().eq("medicine_name",medicineName));
        medicine.setMedicineCount(count);
        medicine.setStatus(status);
        return success(medicineMapper.updateById(medicine));
    }
}
