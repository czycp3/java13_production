package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.MaterialMessage;
import com.cskaoyan.service.MaterialMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author q4work
 */

@Controller
public class MaterialController {
    @Autowired
    private MaterialMessageService materialMessageService;

    BaseResultVo baseResultVo = new BaseResultVo();

    @RequestMapping("/material/list")
    @ResponseBody
    public BaseResultVo materialMessageList(){
        List<MaterialMessage> materialMessages = materialMessageService.queryAllMaterialMessage();
        int total = materialMessages.size();
        baseResultVo.setRows(materialMessages);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @RequestMapping("/material/search_material_by_materialId")
    @ResponseBody
    public BaseResultVo queryMaterialById(String searchValue,int page,int rows){
        List<MaterialMessage> materialMessages = materialMessageService.queryMaterialById(searchValue);
        int total = materialMessages.size();
        baseResultVo.setRows(materialMessages);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @RequestMapping("/material/search_material_by_materialType")
    @ResponseBody
    public BaseResultVo queryMaterialByType(String searchValue,int page,int rows){
        List<MaterialMessage> materialMessages = materialMessageService.queryMaterialByType(searchValue);
        int total = materialMessages.size();
        baseResultVo.setRows(materialMessages);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @RequestMapping("/material/delete_batch")
    @ResponseBody
    public String deleteMaterialById(String[] ids){
        materialMessageService.deleteMaterialById(ids);
        return "1111";
    }

    /***************配置视图解析器****************************/
    @RequestMapping("/material/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "ok";
    }

    @RequestMapping("/material/find")
    public String materialList() {
        return "material_list";
    }


    @RequestMapping("/material/add_judge")
    public String materialAddJudge() {
        return "material_add";
    }

    @RequestMapping("/material/add")
    public String materialAdd() {
        return "material_add";
    }

    @RequestMapping("/material/insert")
    @ResponseBody
    public String materialInsert(MaterialMessage materialMessage) {
        materialMessageService.insertMaterialMessage(materialMessage);
        return "1111";
    }
    @RequestMapping("/material/edit_judge")
    public String materialEditJudge() {
        return "material_edit";
    }

    @RequestMapping("/material/edit")
    public String materialEdit() {
        return "material_edit";
    }

    @RequestMapping("/material/update_all")
    public String materialUpdate(MaterialMessage materialMessage){
        materialMessageService.materialEdit(materialMessage);
        return "111";
    }

    @RequestMapping("/material/update_note")
    public String materialUpdateNote(MaterialMessage materialMessage){
        materialMessageService.materialEdit(materialMessage);
        return "111";
    }

    @RequestMapping("/material/get_data")
    @ResponseBody
    public List materialGetData(){
        BaseResultVo baseResultVo = new BaseResultVo();
        List<MaterialMessage> list = materialMessageService.queryAllMaterialMessage();
        return list;
    }

}
