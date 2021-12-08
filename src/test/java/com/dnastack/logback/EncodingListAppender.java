package com.dnastack.logback;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.encoder.Encoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EncodingListAppender<E> extends AppenderBase<E> {

    public List<E> list = new ArrayList();
    protected Encoder<E> encoder;

    public void setEncoder(Encoder<E> encoder) {
        this.encoder = encoder;
    }

    protected void append(E e) {
        try {
            this.encoder.doEncode(e);
        } catch (IOException exception) {
            return;
        }
        this.list.add(e);
    }

}
