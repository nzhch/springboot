CREATE TABLE IF NOT EXISTS Account (
  id smallint(5) unsigned NOT NULL auto_increment,
  name varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  starttime DATE ,
  endtime DATE NOT NULL,
  admin TINYINT NOT NULL,
  PRIMARY KEY  (name)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;