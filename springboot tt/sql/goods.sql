CREATE TABLE IF NOT EXISTS Goods (
  id smallint(5) unsigned NOT NULL auto_increment,
  goodsId  int(30)	NOT NULL
  statDate varchar(50) NOT NULL,
  goodsName  varchar(255) NOT NULL,
  goodsFavCnt  varchar(50) NOT NULL,
  goodsUv  varchar(50) NOT NULL,
  goodsPv  varchar(50) NOT NULL,
  payOrdrCnt  varchar(50) NOT NULL,
  goodsVcr  varchar(50) NOT NULL,
  pctGoodsVcr  varchar(50) NOT NULL,
  payOrdrGoodsQty  varchar(50) NOT NULL,
  payOrdrUsrCnt  varchar(50) NOT NULL,
  payOrdrAmt  varchar(50) NOT NULL,
  cfmOrdrCnt  varchar(50) NOT NULL,
  cfmOrdrGoodsQty  varchar(50) NOT NULL,
  isNewstyle  varchar(50) NOT NULL,
  PRIMARY KEY  (goodsId)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

