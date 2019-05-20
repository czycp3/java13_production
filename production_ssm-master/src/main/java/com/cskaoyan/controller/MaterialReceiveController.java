package com.cskaoyan.controller;

        import com.cskaoyan.bean.BaseResultVo;
        import com.cskaoyan.bean.MaterialReceive;
        import com.cskaoyan.service.MaterialReceiveService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import java.util.List;

@Controller
public class MaterialReceiveController {
    @Autowired
    private MaterialReceiveService materialReceiveService;

    BaseResultVo baseResultVo = new BaseResultVo();

    @RequestMapping("/materialReceive/find")
    public String materialReceiveFind(){
        return "materialReceive_list";
    }


    @RequestMapping("/materialReceive/list")
    @ResponseBody
    public BaseResultVo materialReceiveList(){
        BaseResultVo resultVo = new BaseResultVo();
        List list = materialReceiveService.queryAllMaterialReceive();
        System.out.println(list);
        resultVo.setTotal(list.size());
        resultVo.setRows(list);
        return resultVo;
    }

    @RequestMapping("/materialReceive/add_judge")
    public String materialReceiveAddJudge(){
        return "materialReceive_add";
    }

    @RequestMapping("/materialReceive/update_all")
    public String materialReceiveInsert(MaterialReceive materialReceive,int ammount,String materialId){
        materialReceive.setAmount(ammount);
        materialReceiveService.materialReceiveUpdateAll(materialReceive,materialId);
        return "materialReceive_add";
    }


    @RequestMapping("/materialReceive/add")
    public String materialReceiveAdd(){
        return "materialReceive_add";
    }

    @RequestMapping("/materialReceive/edit_judge")
    public String materialReceiveEditJudge(){
        return "materialReceive_edit";
    }

    @RequestMapping("/materialReceive/edit")
    public String materialReceiveEdit(){
        return "materialReceive_edit";
    }

    @RequestMapping("/materialReceive/insert")
    @ResponseBody
    public String materialReceiveUpdateAll(MaterialReceive materialReceive,int ammount,String materialId){
        materialReceive.setAmount(ammount);
        System.out.println(materialReceive);
        materialReceiveService.insertmaterialReceive(materialReceive,materialId);
        return "11";
    }

    @RequestMapping("/materialReceive/delete_judge")
    public String materialReceiveDeleteJudge(){
        return "materialReceive_edit";
    }

    @RequestMapping("/materialReceive/delete_batch")
    @ResponseBody
    public String materialReceiveDelete(String[] ids){
        materialReceiveService.deleteById(ids);
        return "11";
    }
}
