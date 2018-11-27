package com.jjshome.Consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jjshome.cloudoa.nhr.service.EmpInfoService;
import com.leyoujia.purview.api.IPurviewService;
import com.leyoujia.purview.common.entity.PurviewModel;
import com.leyoujia.purview.common.model.ResultModel;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.erp.remote.main.dubbo.service.ICwService;

public class ConsumerClient extends AbstractJavaSamplerClient {

    //private String methodName;
    private SampleResult sampleResult = new SampleResult();
    private static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("spring-dubbo-customer.xml");
    private IPurviewService iPurviewService;
    private ICwService iCwService;

    /**
     * 指定传入的参数，用于在jmeter中添加参数
     * @param context
     */
/*    public Arguments getDefaultParameters(){
        Arguments params = new Arguments();
        params.addArgument("title","");
        params.addArgument("erpStoreId", "");
        params.addArgument("latitude", "");
        params.addArgument("longitude","");
        params.addArgument("saleType","");
        return params;
    }*/

    /**
     * 初始化加载配置文件
     *
     * @param context
     */
    @Override
    public void setupTest(JavaSamplerContext context) {
        //getLogger().info("加载xml文件中对应的BeamName的值");
        iCwService = (ICwService) CONTEXT.getBean("iCwService");//获取dubbo配置项中的数据
    }

//    @Override
//    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
//        //getLogger().info("----------------测试开始----------------");
//        sampleResult.sampleStart();//开始计
//        CONTEXT.start();
//        ResultModel<PurviewModel> resultModel = iPurviewService.checkPourview("33004795", "EAS_COMPAY_KEY");
//        String strJson = JSON.toJSONString(resultModel);//object转json字符串
//        getLogger().info(strJson);
//        JSONObject jsonObject = JSON.parseObject(strJson);//json字符转转json对象
//        getLogger().info(jsonObject.getString("success"));
//        if ("true".equals(jsonObject.getString("success")) && null != jsonObject.getString("data")) {
//            sampleResult.setResponseData(strJson, null);
//            sampleResult.setContentType(SampleResult.TEXT);
//            sampleResult.setSuccessful(true);
//        } else {
//            sampleResult.setResponseData(strJson, null);
//            sampleResult.setContentType(SampleResult.TEXT);
//            sampleResult.setSuccessful(false);
//        }
//        //System.out.println(strJson);
//        return sampleResult;//返回结果
//    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        //getLogger().info("----------------测试开始----------------");
        sampleResult.sampleStart();//开始计
        CONTEXT.start();
        boolean resultModel = iCwService.contractReview("50333080558","55002363");
        if (resultModel){
            getLogger().info("11111111111111111111111111111111");
        }else {
            getLogger().info("22222222222222222222222222222222");
        }
        return sampleResult;//返回结果
    }

    @Override
    public void teardownTest(JavaSamplerContext context) {
        sampleResult.sampleEnd();//结束技计时
        CONTEXT.destroy();
        getLogger().info("----------------测试结束----------------");
    }
}
