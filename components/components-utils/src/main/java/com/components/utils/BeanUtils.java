package com.components.utils;

import com.alibaba.fastjson.JSON;
import com.components.utils.exception.BusinessException;
import net.sf.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 基于cglib进行Bean Copy
 *
 * @author CaiQing
 */
public class BeanUtils {

    private BeanUtils() {}

    /**
     * 基于cglib进行对象复制
     *
     * @param source 被复制的对象
     * @param clazz 复制对象类型
     * @return
     */
    public static <T> T copy(Object source, Class<T> clazz) {
        if (EmptyUtils.isEmpty(source)) {
            return null;
        }
        T target = instantiate(clazz);
        BeanCopier copier = BeanCopier.create(source.getClass(), clazz, false);
        copier.copy(source, target, null);
        return target;
    }

    /**
     * 基于cglib进行对象复制
     *
     * @param source 被复制的对象
     * @param target 复制对象
     * @return
     */
    public static void copy(Object source, Object target) {
        ValidationUtil.checkArgument(Objects.nonNull(source), "The source must not be null");
        ValidationUtil.checkArgument(Objects.nonNull(target),  "The target must not be null");
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        copier.copy(source, target, null);
    }

    /**
     * 基于cglib进行对象组复制
     *
     * @param datas 被复制的对象数组
     * @param clazz 复制对象
     * @return
     */
    public static <T> List<T> copyByList(List<?> datas, Class<T> clazz) {
        if (EmptyUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        List<T> result = new ArrayList<>(datas.size());
        for (Object data : datas) {
            result.add(copy(data, clazz));
        }
        return result;
    }

    /**
     * 利用fastjson进行深拷贝
     *
     * @param datas
     * @param clazz
     * @return
     */
    public static <T> List<T> deepCopyByList(List<?> datas, Class<T> clazz) {
        if (EmptyUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return JSON.parseArray(JSON.toJSONString(datas), clazz);
    }

    /**
     * 利用fastjson进行深拷贝
     *
     * @param data
     * @param clazz
     * @return
     */
    public static <T> T deepCopy(Object data, Class<T> clazz) {
        if (EmptyUtils.isEmpty(data)) {
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(data), clazz);
    }

    /**
     * 通过class实例化对象
     *
     * @param clazz
     * @return
     * @throws RuntimeException
     */
    public static <T> T instantiate(Class<T> clazz) {
        ValidationUtil.checkArgument(Objects.nonNull(clazz), "The class must not be null");
        try {
            return clazz.newInstance();
        } catch (InstantiationException ex) {
            throw new BusinessException("SYSTEM_ERROR", clazz + ":Is it an abstract class?");
        } catch (IllegalAccessException ex) {
            throw new BusinessException("SYSTEM_ERROR", clazz + ":Is the constructor accessible?");
        }
    }

}
