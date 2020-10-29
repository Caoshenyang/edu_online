import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MySqlCodeGenerator {

    public static void main(String[] args) {

        //1、全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)//开启AR模式
                .setAuthor("caoshenyang")//设置作者
                .setOpen(false)//生成后打开资源管理器
                //生成路径(一般都是生成在此项目的src/main/java下面)
                .setOutputDir("D:\\edu_online\\edu_service\\edu_service_education8080" + "/src/main/java")
                .setFileOverride(true)//第二次生成会把第一次生成的覆盖掉
                .setIdType(IdType.AUTO)//主键策略
                .setServiceName("%sService")//生成的service接口名字首字母是否为I，这样设置就没有I
                .setIdType(IdType.ID_WORKER)//主键策略
                .setDateType(DateType.ONLY_DATE)//定义生成的实体类中日期类型
                .setSwagger2(true)//开启swagger2模式
                .setBaseResultMap(true)//生成resultMap
                .setBaseColumnList(true);//在xml中生成基础列

        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)//数据库类型
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/edu_online?useUnicode=true&&characterEncoding=utf8&&useSSL=false&&serverTimezone=Asia/Shanghai")
                .setUsername("root")
                .setPassword("root");
        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//开启全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)//下划线到驼峰的命名方式
                .setTablePrefix("edu_")//表名前缀
                .setEntityLombokModel(true)//使用lombok
                .setRestControllerStyle(true)//restful api风格控制器
                .setControllerMappingHyphenStyle(true)//url中驼峰转连接符
                .setInclude("edu_teacher");//逆向工程使用的表
        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.yang")//设置包名的parent
                .setModuleName("education")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity");
        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        //6、执行
        autoGenerator.execute();
    }
}
