package com.jd.dbw.view;

import com.jd.dbw.dao.DataService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Map;

public class VeloDrawer {
    public static String draw() {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();

        Template t = ve.getTemplate("mail.vm");
        VelocityContext ctx = new VelocityContext();

        Map<String, Integer> tables = DataService.getTableData();
        ctx.put("map", tables);

        StringWriter sw = new StringWriter();

        t.merge(ctx, sw);

        return sw.toString();
    }
}

