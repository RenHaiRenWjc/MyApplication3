package com.example.javaproject.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:com.example.javaproject.vm
 * Description: oom ,堆内存溢出
 * VM args：-Xms30m -Xmx30m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * wjChen on 2019/5/18$
 */
public class OomDemo {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        while (true) {
            i++;
            if (i % 10000 == 0) System.out.println("i=" + i);//一万次输出一下
            list.add(new Object());

        }

    }

  /*
     异常信息
    Heap dump file created [41605066 bytes in 0.143 secs]
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    at java.util.Arrays.copyOf(Arrays.java:3210)
    at java.util.Arrays.copyOf(Arrays.java:3181)
    at java.util.ArrayList.grow(ArrayList.java:261)
    at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
    at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
    at java.util.ArrayList.add(ArrayList.java:458)
    at com.example.javaproject.vm.OomDemo.main(OomDemo.java:19)
    Heap
    PSYoungGen      total 9216K, used 4179K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
    eden space 8192K, 51% used [0x00000000ff600000,0x00000000ffa14dd8,0x00000000ffe00000)
    from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
    to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
    ParOldGen       total 20480K, used 20460K [0x00000000fe200000, 0x00000000ff600000, 0x00000000ff600000)
    object space 20480K, 99% used [0x00000000fe200000,0x00000000ff5fb180,0x00000000ff600000)
    Metaspace       used 3419K, capacity 4500K, committed 4864K, reserved 1056768K
    class space    used 357K, capacity 388K, committed 512K, reserved 1048576K

    */

}
