/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/10/21 20:07:13                          */
/*==============================================================*/


drop table if exists tb_brand;

drop table if exists tb_category_brand;

drop table if exists tb_content;

drop table if exists tb_content_category;

drop table if exists tb_goods;

drop table if exists tb_goods_image;

drop table if exists tb_goods_storage;

drop table if exists tb_item_cat;

drop table if exists tb_item_param;

drop table if exists tb_item_param_item;

drop table if exists tb_order;

drop table if exists tb_order_item;

drop table if exists tb_order_shipping;

drop table if exists tb_product;

drop table if exists tb_property;

drop table if exists tb_property_enum;

drop table if exists tb_recive_address;

drop table if exists tb_user;

/*==============================================================*/
/* Table: tb_brand                                              */
/*==============================================================*/
create table tb_brand
(
   BRAND_ID             bigint not null auto_increment comment '品牌ID',
   BRAND_NAME           varchar(128) comment '品牌名称',
   EN_NAME              varchar(128) comment '英文名',
   PINYIN               varchar(128) comment '拼音',
   INITIAL              char(1) comment '首字母',
   LOGO_URL             varchar(1024) comment 'logo路径',
   IS_DELETE            char(1) comment '是否删除',
   ADD_USER             bigint comment '添加人',
   ADD_TIME             timestamp comment '添加时间',
   MOD_USER             bigint comment '修改人',
   MOD_TIME             timestamp comment '修改时间',
   primary key (BRAND_ID)
);

alter table tb_brand comment '品牌表';

/*==============================================================*/
/* Table: tb_category_brand                                     */
/*==============================================================*/
create table tb_category_brand
(
   BRAND_ID             bigint not null comment '品牌iD',
   item_cat_id          bigint(20) not null comment '类目ID',
   primary key (BRAND_ID, item_cat_id)
);

alter table tb_category_brand comment '分类品牌关系表';

/*==============================================================*/
/* Table: tb_content                                            */
/*==============================================================*/
create table tb_content
(
   ad_id                bigint(20) not null auto_increment,
   category_id          bigint(20) not null comment '广告类目ID',
   title                varchar(200) default NULL comment '广告标题',
   sub_title            varchar(100) default NULL comment '子标题',
   title_desc           varchar(500) default NULL comment '标题描述',
   url                  varchar(500) default NULL comment '链接',
   pic                  varchar(300) default NULL comment '图片绝对路径',
   pic2                 varchar(300) default NULL comment '图片2',
   goods_id             bigint comment '楼层广告商品ID',
   content              text comment '内容',
   created              datetime default NULL,
   updated              datetime default NULL,
   primary key (ad_id)
);

alter table tb_content comment '广告表';

/*==============================================================*/
/* Table: tb_content_category                                   */
/*==============================================================*/
create table tb_content_category
(
   category_id          bigint(20) not null auto_increment comment '广告位ID',
   space_code           varchar(256) comment '广告位编码',
   parent_id            bigint(20) default NULL comment '父广告位ID=0时，代表的是一级的类目',
   name                 varchar(50) default NULL comment '分类名称',
   status               int(1) default 1 comment '状态。可选值:1(正常),2(删除)',
   sort_order           int(4) default NULL comment '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
   is_parent            tinyint(1) default 1 comment '该类目是否为父类目，1为true，0为false',
   created              datetime default NULL comment '创建时间',
   updated              datetime default NULL comment '创建时间',
   primary key (category_id)
);

alter table tb_content_category comment '广告位表';

/*==============================================================*/
/* Table: tb_goods                                              */
/*==============================================================*/
create table tb_goods
(
   GOODS_ID             bigint not null comment '商品编号',
   PROD_ID              bigint comment '商品编号',
   GOODS_NAME           varchar(512) not null comment '商品名称',
   COST_PRICE           numeric(15,2) comment '商品分类编号',
   SELL_PRICE           numeric(15,2) not null comment '商品品牌',
   STATUS               char(1) comment '1、下架
            2、上架
            状态：3、冻结',
   COLOR                varchar(256) comment '颜色',
   VERSION              varchar(1024) comment '版本',
   STOCK_WARNING        numeric(22,0) comment '库存预警',
   IS_DELETE            char(1) comment 'Y：是
            N：否',
   ADD_USER_ID          bigint comment '添加人',
   ADD_TIME             timestamp comment '添加时间',
   MOD_USER_ID          bigint comment '修改人',
   MOD_TIME             timestamp comment '修改时间',
   primary key (GOODS_ID)
);

alter table tb_goods comment '商品表，也是SKU表';

/*==============================================================*/
/* Table: tb_goods_image                                        */
/*==============================================================*/
create table tb_goods_image
(
   IMG_ID               bigint not null auto_increment comment '图片ID',
   GOODS_ID             bigint comment '商品ID',
   IMG_URL              varchar(1024) comment '图片路径',
   IMG_EXT              varchar(128) comment '图片扩展名',
   SORT                 int comment '排序',
   IS_DELETE            char(1) comment '是否删除',
   primary key (IMG_ID)
);

alter table tb_goods_image comment '商品图片表';

/*==============================================================*/
/* Table: tb_goods_storage                                      */
/*==============================================================*/
create table tb_goods_storage
(
   GOODS_ID             bigint not null comment '商品编号',
   STORAGE_NUM          int not null comment '商品库存',
   primary key (GOODS_ID)
);

alter table tb_goods_storage comment '商品库存表';

/*==============================================================*/
/* Table: tb_item_cat                                           */
/*==============================================================*/
create table tb_item_cat
(
   item_cat_id          bigint(20) not null auto_increment comment '类目ID',
   parent_id            bigint(20) default NULL comment '父类目ID=0时，代表的是一级的类目',
   name                 varchar(50) default NULL comment '类目名称',
   status               int(1) default 1 comment '状态。可选值:1(正常),2(删除)',
   sort_order           int(4) default NULL comment '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
   is_parent            tinyint(1) default 1 comment '该类目是否为父类目，1为true，0为false',
   created              datetime default NULL comment '创建时间',
   updated              datetime default NULL comment '创建时间',
   primary key (item_cat_id),
   key parent_id (parent_id, status),
   key sort_order (sort_order)
);

alter table tb_item_cat comment '商品分类表';

/*==============================================================*/
/* Table: tb_item_param                                         */
/*==============================================================*/
create table tb_item_param
(
   id                   bigint(20) not null auto_increment,
   item_cat_id          bigint(20) default NULL comment '商品类目ID',
   param_data           text comment '参数数据，格式为json格式',
   created              datetime default NULL,
   updated              datetime default NULL,
   primary key (id),
   key item_cat_id (item_cat_id)
);

alter table tb_item_param comment '属性模板表';

/*==============================================================*/
/* Table: tb_item_param_item                                    */
/*==============================================================*/
create table tb_item_param_item
(
   id                   bigint(20) not null auto_increment,
   prod_id              bigint not null comment '商品编号',
   param_data           text comment '参数数据，格式为json格式',
   created              datetime default NULL,
   updated              datetime default NULL,
   primary key (id)
);

alter table tb_item_param_item comment '商品属性表';

/*==============================================================*/
/* Table: tb_order                                              */
/*==============================================================*/
create table tb_order
(
   order_id             varchar(50) not null,
   payment              varchar(50),
   payment_type         int(2) default NULL comment '支付类型，1、在线支付，2、货到付款',
   post_fee             varchar(50),
   status               int(10) default NULL comment '状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭',
   create_time          datetime default NULL comment '订单创建时间',
   update_time          datetime default NULL comment '订单更新时间',
   payment_time         datetime default NULL comment '付款时间',
   consign_time         datetime default NULL comment '发货时间',
   end_time             datetime default NULL comment '交易完成时间',
   close_time           datetime default NULL comment '交易关闭时间',
   shipping_name        varchar(20),
   shipping_code        varchar(20),
   user_id              bigint(20) default NULL comment '用户id',
   buyer_message        varchar(100),
   buyer_nick           varchar(50),
   buyer_rate           int(2) default NULL comment '买家是否已经评价',
   primary key (order_id),
   key create_time (create_time),
   key buyer_nick (buyer_nick),
   key status (status),
   key payment_type (payment_type)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

alter table tb_order comment '订单表';

/*==============================================================*/
/* Table: tb_order_item                                         */
/*==============================================================*/
create table tb_order_item
(
   id                   varchar(20) not null,
   item_id              varchar(50),
   order_id             varchar(50),
   num                  int(10) default NULL comment '商品购买数量',
   title                varchar(200),
   price                bigint(50) default NULL comment '商品单价',
   total_fee            bigint(50) default NULL comment '商品总金额',
   pic_path             varchar(200),
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

alter table tb_order_item comment '订单明细表';

/*==============================================================*/
/* Table: tb_order_shipping                                     */
/*==============================================================*/
create table tb_order_shipping
(
   order_id             varchar(50) not null comment '订单ID',
   receiver_name        varchar(20) default NULL comment '收货人全名',
   receiver_phone       varchar(20) default NULL comment '固定电话',
   receiver_mobile      varchar(30) default NULL comment '移动电话',
   receiver_state       varchar(10) default NULL comment '省份',
   receiver_city        varchar(10) default NULL comment '城市',
   receiver_district    varchar(20) default NULL comment '区/县',
   receiver_address     varchar(200) default NULL comment '收货地址，如：xx路xx号',
   receiver_zip         varchar(6) default NULL comment '邮政编码,如：310001',
   created              datetime default NULL,
   updated              datetime default NULL,
   primary key (order_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table tb_order_shipping comment '订单物流表';

/*==============================================================*/
/* Table: tb_product                                            */
/*==============================================================*/
create table tb_product
(
   PROD_ID              bigint not null comment '产品ID',
   item_cat_id          bigint(20) comment '类目ID',
   BRAND_ID             bigint comment '品牌ID',
   PROD_NAME            varchar(256) comment '商品名称',
   AD_WORD              varchar(1000) comment '商品广告词',
   PROD_DESC            longtext comment '商品介绍',
   PACKAGING_LIST       varchar(256) comment '包装清单',
   AFTER_SALE_SERVICE   varchar(1024) comment '售后服务',
   STOCK_WARNING        numeric(22,0) comment '库存预警',
   WEIGHT               numeric(15,2) comment '重量kg',
   VOLUME               numeric(15,2) comment '体积m3',
   TEMPLATE_ID          char(1) comment '颜色版本模板标识
            1、无颜色无版本
            2、有颜色无版本
            3、无颜色有版本
            4、有颜色有版本',
   IS_DELETE            char(1) comment '是否删除Y：是 N：否',
   ADD_USER_ID          bigint comment '添加人',
   ADD_TIME             timestamp comment '添加时间',
   MOD_USER_ID          bigint comment '修改人',
   MOD_TIME             timestamp comment '修改时间',
   primary key (PROD_ID)
);

alter table tb_product comment '产品表(sku表)';

/*==============================================================*/
/* Table: tb_property                                           */
/*==============================================================*/
create table tb_property
(
   PROP_ID              bigint not null auto_increment comment '属性ID',
   PROP_NAME            varchar(256) comment '属性名称',
   INPUT_TYPE           char(1) comment '输入方式
            1、文本框
            2、下拉框',
   SORT                 int comment '排序',
   IS_NULLABLE          char(1) comment '允许为空
            Y：可以为空
            N：不能为空
            ',
   PROP_GROUP           varchar(256) comment '属性组',
   PROP_GROUP_SORT      int comment '属性组排序',
   IS_DELETE            char(1) comment '是否删除Y：是
            N：否',
   ADD_USER             bigint comment '添加人',
   ADD_TIME             timestamp comment '添加时间',
   MOD_USER             bigint comment '修改人',
   MOD_TIME             timestamp comment '修改时间',
   primary key (PROP_ID)
);

alter table tb_property comment '商品属性表';

/*==============================================================*/
/* Table: tb_property_enum                                      */
/*==============================================================*/
create table tb_property_enum
(
   PROP_ENUM_ID         bigint not null auto_increment comment '属性枚举值ID',
   PROP_ID              bigint comment '属性ID',
   PROP_ENUM_VALUE      varchar(512) comment '属性枚举值VALUE',
   primary key (PROP_ENUM_ID)
);

alter table tb_property_enum comment '属性枚举值表';

/*==============================================================*/
/* Table: tb_recive_address                                     */
/*==============================================================*/
create table tb_recive_address
(
   id                   bigint not null auto_increment comment 'id',
   user_id              bigint(20) comment '用户id',
   recive_name          varchar(50) comment '收货人姓名',
   recive_province      varchar(10) comment '省',
   recive_city          varchar(10) comment '市',
   recive_area          varchar(10) comment '县、区',
   recive_address       varchar(100) comment '收货地址',
   telphone             varchar(12) comment '固定电话',
   mobile               varchar(12) comment '手机',
   email                varchar(20) comment '邮箱',
   isdefault            tinyint comment '是否为默认',
   addr_name            varchar(10) comment '收货地址名称',
   primary key (id)
);

alter table tb_recive_address comment '收货地址表';

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   user_id              bigint(20) not null auto_increment comment '用户id',
   username             varchar(50) not null comment '用户名',
   password             varchar(32) not null comment '密码，加密存储',
   phone                varchar(20) default NULL comment '注册手机号',
   email                varchar(50) default NULL comment '注册邮箱',
   created              datetime not null,
   updated              datetime not null,
   primary key (user_id),
   unique key username (username),
   unique key phone (phone),
   unique key email (email)
);

alter table tb_user comment '用户表';

