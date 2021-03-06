package com.shop.controller.admin;

import com.shop.model.domain.Cate;
import com.shop.model.domain.Promotion;
import com.shop.model.service.CateManagerInterface;
import com.shop.model.service.PromotionManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private CateManagerInterface cateManager;
    @Autowired
    private PromotionManagerInterface promotionService;

    @RequestMapping({"/", ""})
    public ModelAndView homePage(){
        return new ModelAndView("admin/homepage");
    }

    @RequestMapping("/cate_manage")
    public String cateManage(){
        return "admin/cate_manage";
    }

    @RequestMapping("/add_cate")
    public ModelAndView addCate(){
        ModelAndView modelAndView = new ModelAndView();
        List<Cate> cates = cateManager.getAllCates();
        modelAndView.addObject("cates", cates);
        modelAndView.setViewName("admin/add_cate");
        return modelAndView;
    }

    @RequestMapping("/add_cate_post")
    public String addCatePost(Cate cate, RedirectAttributes model){
        if (cateManager.hasCate(cate.getCate_name())){
            model.addFlashAttribute("warning", "分类已存在！");
        }
        else {
            cateManager.addCate(cate);
            model.addFlashAttribute("success", "添加成功！");
        }
        return "redirect:/admin/add_cate";
    }

    @RequestMapping("/get_cates")
    public ModelAndView getCates(){
        ModelAndView modelAndView = new ModelAndView();
        List<Cate> cates = cateManager.getAllCates();
        modelAndView.addObject("cates", cates);
        modelAndView.setViewName("admin/get_cates");
        return modelAndView;
    }

    @RequestMapping("/edit_cate/{cate_id}")
    public ModelAndView editCate(@PathVariable("cate_id")Long cateId){
        ModelAndView modelAndView = new ModelAndView();
        Cate cateToEdit = cateManager.getCateById(cateId);
        List<Cate> cates = cateManager.getAllCates();
        modelAndView.addObject("cateToEdit", cateToEdit);
        modelAndView.addObject("cates", cates);
        modelAndView.setViewName("admin/edit_cate");
        return modelAndView;
    }

    @RequestMapping("/edit_cate_post")
    public String editCatePost(Cate cate, RedirectAttributes model){
        if (cateManager.hasCate(cate.getCate_name())){
            model.addFlashAttribute("warning", "分类已存在！");
        }
        else {
            cateManager.changeCateName(cate);
            model.addFlashAttribute("success", "修改成功！");
        }
        return "redirect:/admin/get_cates";
    }

    @RequestMapping("/delete_cate")
    public ModelAndView deleteCate(){
        ModelAndView modelAndView = new ModelAndView();
        List<Cate> cates = cateManager.getAllCates();
        modelAndView.addObject("cates", cates);
        modelAndView.setViewName("admin/delete_cate");
        return modelAndView;
    }

    @RequestMapping("/delete_cate/{cate_id}")
    public String deleteCateDo(@PathVariable("cate_id")Long cate_id, RedirectAttributes model){
        cateManager.deleteCate(cate_id);
        model.addFlashAttribute("success", "删除成功！");
        return "redirect:/admin/delete_cate";
    }

    @RequestMapping("/promote_manage")
    public String promotionManage(){
        return "admin/promotion_manage";
    }

    @RequestMapping("/add_promotion")
    public String addPromotion(){
        return "admin/add_promotion";
    }

    @RequestMapping("/get_promotions")
    public ModelAndView getPromotions(){
        ModelAndView modelAndView = new ModelAndView();
        List<Promotion> promotions = promotionService.getAllSitePromotions();
        modelAndView.addObject("promotions", promotions);
        modelAndView.setViewName("admin/get_promotions");
        return modelAndView;
    }

    @RequestMapping("/add_promotion_post")
    public String addPromotionPost(Promotion promotion,
                                   RedirectAttributes model){
        promotionService.addPromotion(promotion, null);
        model.addFlashAttribute("success", "添加成功");
        return "redirect:/admin/get_promotions";
    }

    @RequestMapping("/edit_promotion/{promotion_id}")
    public ModelAndView editPromotion(@PathVariable("promotion_id")Long promotinId){
        ModelAndView modelAndView = new ModelAndView();
        Promotion promotion = promotionService.getPromotionById(promotinId);
        modelAndView.addObject("promotion", promotion);
        modelAndView.setViewName("admin/edit_promotion");
        return modelAndView;
    }

    @RequestMapping("/edit_promotion_post")
    public String editPromotionPost(Promotion promotion,
                                    RedirectAttributes redirectAttributes){
        promotionService.changePromotion(promotion, null);
        redirectAttributes.addFlashAttribute("success", "修改成功！");
        return "redirect:/admin/get_promotions";
    }

    @RequestMapping("/delete_promotion/{promotion_id}")
    public String deletePromotion(@PathVariable("promotion_id")Long promotionId,
                                  RedirectAttributes redirectAttributes){
        promotionService.deletePromotion(promotionId);
        redirectAttributes.addFlashAttribute("success", "删除成功！");
        return "redirect:/admin/get_promotions";

    }

}
