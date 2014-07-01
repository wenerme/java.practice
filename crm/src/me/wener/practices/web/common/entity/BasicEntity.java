package me.wener.practices.web.common.entity;


import java.io.Serializable;
import javax.persistence.Version;

public abstract class BasicEntity implements Serializable
{
    @Version
    private Integer _version;
}
