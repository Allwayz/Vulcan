package com.vulcan.model.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.Medicine;
import com.vulcan.model.entity.MedicineType;
import com.vulcan.model.mapper.MedicineTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Allwayz
 * @since 2020-04-04
 */
@Transactional
@RestController
@RequestMapping("/medicine-type")
public class MedicineTypeController extends ApiController {
    @Autowired
    private MedicineTypeMapper medicineTypeMapper;

    /**
     * <p>
     *      获取所有药品分类列表
     * </p>
     * @return
     */
    @GetMapping()
    public R getMedicineType(){
        List<MedicineType> medicineTypeList = medicineTypeMapper.selectList(new QueryWrapper<>());
        return success(medicineTypeList);
    }

    /**
     * <p>
     *     新建一个药品分类
     * </p>
     * @param medicineTypeName
     * @param status
     * @return
     */
    @PostMapping()
    public R addMedicineType(String medicineTypeName,String status){
        if(!medicineTypeName.isEmpty()){
            MedicineType medicineType = MedicineType.builder()
                    .medicineTypeName(medicineTypeName)
                    .medicineTypeStatus(status)
                    .build();
            return success(medicineTypeMapper.insert(medicineType));
        }
        return failed("please enter the medicine type");
    }
}
