package com.nhnent.edu.springboot.autoconfig.conditional.conditionaldemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 아래의 모든 테스트 케이스가 성공할 수 있도록 프로젝트를 수정해 주세요.
 * 下記のすべてのテストケースが成功できるようにプロジェクトを修正してください。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionalDemoConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 이 테스트를 성공하려면 TODO(1) 를 수정하세요.
     * このテストを成功するには,TODO(1)を修正してください。
     */
    @Test
    public void sayYesComponent() {
        assertThat(applicationContext.containsBean("sayYesComponent"), is(TRUE));
    }

    /**
     * 이 테스트를 성공하려면 TODO(2) 를 수정하세요.
     * このテストを成功するには,TODO(2)を修正してください。
     */
    @Test
    public void sayYesComponentWeb() {
        assertThat(applicationContext.containsBean("sayYesComponentWeb"), is(TRUE));
    }

    /**
     * 이 테스트를 성공하려면 TODO(2) 를 수정하세요.
     * このテストを成功するには,TODO(2)を修正してください。
     */
    @Test
    public void sayYesComponentNotWeb() {
        assertThat(applicationContext.containsBean("sayYesComponentNotWeb"), is(FALSE));
    }

    /**
     * 이 테스트를 성공하려면 TODO(3) 를 수정하세요.
     * このテストを成功するには,TODO(3)を修正してください。
     */
    @Test
    public void sayYesComponentOnBean() {
        assertThat(applicationContext.containsBean("sayYesComponentOnBean"), is(TRUE));
    }

    @Test
    public void sayYesComponentOnMissingBean() {
        assertThat(applicationContext.containsBean("sayYesComponentOnMissingBean"), is(FALSE));
    }

    /**
     * 이 테스트를 성공하려면 TODO(4) 를 수정하세요.
     * このテストを成功するには,TODO(4)を修正してください。
     */
    @Test
    public void sayYesComponentOnClass() {
        assertThat(applicationContext.containsBean("sayYesComponentOnClass"), is(TRUE));
    }

    @Test
    public void sayYesComponentOnMissingClass() {
        assertThat(applicationContext.containsBean("sayYesComponentOnMissingClass"), is(TRUE));
    }

    /**
     * 이 테스트를 성공하려면 TODO(5) 를 수정하세요.
     * このテストを成功するには,TODO(5)を修正してください。
     */
    @Test
    public void sayYesComponentOnProperty() {
        assertThat(applicationContext.containsBean("sayYesComponentOnProperty"), is(TRUE));
    }

    /**
     * 이 테스트를 성공하려면 TODO(6) 를 수정하세요.
     * このテストを成功するには,TODO(6)を修正してください。
     */
    @Test
    public void sayYesComponentOnResource() {
        assertThat(applicationContext.containsBean("sayYesComponentOnResource"), is(TRUE));
    }
}
