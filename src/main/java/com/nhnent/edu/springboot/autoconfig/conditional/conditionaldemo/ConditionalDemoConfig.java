package com.nhnent.edu.springboot.autoconfig.conditional.conditionaldemo;

import com.nhnent.edu.springboot.autoconfig.conditional.conditionaldemo.component.SayNoComponent;
import com.nhnent.edu.springboot.autoconfig.conditional.conditionaldemo.component.SayYesComponent;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class ConditionalDemoConfig {

    /**
     * application.properties 파일에 test property 가 존재하면 아래 빈을 생성한다.
     * @return
     */
    @Bean
    @Conditional(PropertyCheckCondition.class)
    public SayYesComponent sayYesComponent() {
        return new SayYesComponent("Conditional");
    }


    //TODO (2) web application 이 되도록 pom.xml 을 수정한다.
    /**
     * 웹어플리케이션이면 아래 빈을 생성한다.
     * @return
     */
    @ConditionalOnWebApplication
    @Bean
    public SayYesComponent sayYesComponentWeb() {
        return new SayYesComponent("ConditionalOnWebApplication");
    }

    /**
     * 웹어플리케이션이 아니면 아래 빈을 생성한다.
     * @return
     */
    @ConditionalOnNotWebApplication
    @Bean
    public SayYesComponent sayYesComponentNotWeb() {
        return new SayYesComponent("ConditionalOnNotWebApplication");
    }


    /**
     * TODO (3) SayNoComponent.class 타입의 빈이 등록되어 있으면 동작하도록하는  @ConditionalOnBean annotation 선언되어 있다.
     * TODO (3) sayYesComponentOnBean 이 생성되도록 SayNoComponent 빈을 선언하자.
     *
     *
     * sayYesComponentNotWeb 빈이 등록되어 있으면 아래 빈을 생성한다.
     * @return
     */
    @ConditionalOnBean(SayNoComponent.class)
    @Bean
    public SayYesComponent sayYesComponentOnBean() {
        return new SayYesComponent("ConditionalOnBean");
    }

    @Bean
    @ConditionalOnMissingBean(SayNoComponent.class)
    public SayYesComponent sayYesComponentOnMissingBean() {
        return new SayYesComponent("ConditionalOnMissingBean");
    }


    /**
     * TODO (4) Yes 클래스가 존재하면 빈을 생성하는 @ConditionalOnClass annotation이 선언되어 있다.
     * TODO (4) sayYesComponentOnClass 빈이 생성되도록 No 클래스를 rename 하자.
     *
     * @return
     */
    @Bean
    @ConditionalOnClass(name={"com.nhnent.edu.springboot.autoconfig.conditional.conditionaldemo.component.Yes"})
    public SayYesComponent sayYesComponentOnClass() {
        return new SayYesComponent("ConditionalOnClass");
    }

    @Bean
    @ConditionalOnMissingClass(value={"com.nhnent.edu.springboot.autoconfig.conditional.conditionaldemo.component.No"})
    public SayYesComponent sayYesComponentOnMissingClass() {
        return new SayYesComponent("ConditionalOnMissingClass");
    }

    /**
     * TODO (5) test property가 존재하면 빈을 생성하는 @ConditionalOnProperty annotation이 선언되어 있다.
     * TODO (5) sayYesComponentOnProperty 빈이 생성되도록 application.properties파일을 수정하자.
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(value="test")
    public SayYesComponent sayYesComponentOnProperty() {
        return new SayYesComponent("ConditionalOnProperty");
    }

    /**
     * TODO (6) test.txt 파일이 존재하면 빈을 생성하는 @ConditionalOnResource annotation이 선언되어 있다.
     * TODO (6) sayYesComponentOnResource 빈이 생성되도록 test.txt 파일을 생성하자.
     *
     * @return
     */
    @Bean
    @ConditionalOnResource(resources = {"classpath:/test.txt"})
    public SayYesComponent sayYesComponentOnResource() {
        return new SayYesComponent("ConditionalOnResource");
    }


    static class PropertyCheckCondition implements Condition {

        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            // TODO (1)  application.properties 파일에 test property 가 존재하면 true 를 반환
            // Hint property 가져 오기 conditionContext.getEnvironment().getProperty("test")
            return false;
        }
    }
}

