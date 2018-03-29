package com.train.convert;

public interface Convert<K, V> {

    V createTarget();

    V convert(K source);
}
