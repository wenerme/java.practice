package me.wener.lesson.practice.crm.sys.common.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServletAction
{
    /**
     * 设定需要处理的方法类型
     */
    RequestMethod[] method() default {RequestMethod.GET};

    /**
     * 设定动作名,如果没有,则使用方法名
     */
    String action() default "";

    /**
     * 将该方法作为默认的方法
     * 即在没有 action 的时候会调用该方法
     */
    boolean asDefault() default false;

    /**
     * 会被处理的异常, 默认为 {@link Exception},即处理所有异常
     * {@code ServletActionException} 总会被处理
     * 如果异常被处理 则会转发到 error 页面
     * <p/>
     * 如果想要修改 error 页面的内容.
     * 必须抛出 {@link ServletActionException} 或设置 {@link ServletAction#errorMessage()} 参数,
     * 否则使用默认的错误提示
     */
    Class<? extends Throwable>[] handleException() default {Exception.class};

    /**
     * 是否再次抛出该异常,默认为继续抛出
     */
    boolean rethrow() default true;

    /**
     * 错误信息
     * 如果抛出了 {@link ServletActionException}异常,该错误信息会被替代
     */
    String errorMessage() default "";
}