package ${controllerPackage};


import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if moduleName??>/${moduleName}</#if>")
<#if superControllerClass??>
public class ${controllerName} extends ${superControllerClass} {
<#else>
public class ${controllerName} {
</#if>

}
