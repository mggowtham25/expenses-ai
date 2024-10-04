package com.example.expensesaiapi.config;

import com.example.expensesaiapi.constant.Constant;
import com.example.expensesaiapi.util.SwaggerUtil;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        var info = new Info()
                .title("Expenses AI")
                .version(Constant.V1_API_VERSION.replace("/", ""))
                .contact(SwaggerUtil.getOpenApiContact())
                .description("Expenses AI API Service")
                .license(SwaggerUtil.OA_LICENSE);

        return new OpenAPI().info(info);

    }
}
