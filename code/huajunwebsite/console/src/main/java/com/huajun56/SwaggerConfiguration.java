package com.huajun56;

import com.fasterxml.classmate.members.ResolvedMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bond on 2017/3/18.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf()).useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, globalMessage())
                .globalResponseMessage(RequestMethod.POST, globalMessage())
                .globalResponseMessage(RequestMethod.OPTIONS, globalMessage())
                .globalResponseMessage(RequestMethod.DELETE, globalMessage())
                .globalResponseMessage(RequestMethod.PUT, globalMessage())
                .globalResponseMessage(RequestMethod.HEAD, globalMessage())
                .globalResponseMessage(RequestMethod.TRACE, globalMessage())
                .globalResponseMessage(RequestMethod.PATCH, globalMessage())
                .forCodeGeneration(true)
                .enableUrlTemplating(true)
                .groupName("huajun56-portals")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huajun56.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("华军物流-API文档")
                .description(
                        "@description: 本接口文档旨在说明华军物流-Portals系统能访问的计算服务，如在使用过程存在任何疑问请及时与相关开发人员联系，谢谢您使用该文档。" +
                                "***注***：因为服务是分布式服务，服务与应用非同源，因而服务采用CORS标准，请放心使用服务，不会出现跨域请求问题，请注意该技术在各浏览的兼容性！" +
                                "请参考：https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Access_control_CORS")
                .version("v1.0.0")
                .contact(new Contact("", "", "zzdjavajob@163.com"))
                .build();
    }

    private List<ResponseMessage> globalMessage() {
        List<ResponseMessage> messageList = new ArrayList<>();
        messageList.add(new ResponseMessageBuilder().code(200).message("200-请求成功！").responseModel(new ModelRef("请求成功！")).build());
        messageList.add(new ResponseMessageBuilder().code(401).message("401-没有授权！").responseModel(new ModelRef("没有授权！")).build());
        messageList.add(new ResponseMessageBuilder().code(404).message("404-请求的地址不存在！").responseModel(new ModelRef("请求的地址不存在！")).build());
        messageList.add(new ResponseMessageBuilder().code(403).message("403-禁止访问！").responseModel(new ModelRef("禁止访问！")).build());
        messageList.add(new ResponseMessageBuilder().code(405).message("405-HTTP方法不被允许，请确认调用的方法是否正确！").responseModel(new ModelRef("HTTP方法不被允许，请确认调用的方法是否正确！")).build());
        messageList.add(new ResponseMessageBuilder().code(500).message("500-系统错误，请联系系统管理员或开发人员！").responseModel(new ModelRef("系统错误，请联系系统管理员或开发人员！")).build());

        return messageList;
    }
}
