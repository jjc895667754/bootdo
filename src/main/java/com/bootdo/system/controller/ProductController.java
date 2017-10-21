package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.ProductDO;
import com.bootdo.system.service.ProductService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 产品表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-21 22:04:56
 */
 
@Controller
@RequestMapping("/system/product")
public class ProductController extends BaseController {
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	@RequiresPermissions("system:product:product")
	String Product(){
	    return "system/product/product";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:product:product")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductDO> productList = productService.list(query);
		int total = productService.count(query);
		PageUtils pageUtils = new PageUtils(productList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:product:add")
	String add(){
	    return "system/product/add";
	}

	@GetMapping("/edit/{productid}")
	@RequiresPermissions("system:product:edit")
	String edit(@PathVariable("productid") Integer productid,Model model){
		ProductDO product = productService.get(productid);
		model.addAttribute("product", product);
	    return "system/product/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:product:add")
	public R save( ProductDO product){
		if(productService.save(product)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:product:edit")
	public R update( ProductDO product){
		productService.update(product);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:product:remove")
	public R remove( Integer productid){
		if(productService.remove(productid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:product:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] productids){
		productService.batchRemove(productids);
		return R.ok();
	}
	
}
