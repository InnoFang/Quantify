package io.innofang.quantify.model;

/**
 * Created by Inno Fang on 2017/6/8.
 */
public class Bean implements Comparable<Bean> {

    public int before     = -1; // 原始值
    public int after = -1; // 量化后的值
    public int index      = -1; // 下标


    @Override
    public int compareTo(Bean o) {
        return index - o.index;
    }
}
