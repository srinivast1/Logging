create table activity1(str String);

load data local inpath '/home/srini/activity1.xml' overwrite  into table activity1;

select xpath(str,'activity1/userName/text()'), xpath(str,'activity1/websiteName/text()') from activity1;

CREATE TABLE activity1(activity map<string,string>)
ROW FORMAT SERDE 'com.ibm.spss.hive.serde2.xml.XmlSerDe'
WITH SERDEPROPERTIES (
"column.xpath.activity1"="/activity1/*",
)
STORED AS
INPUTFORMAT 'com.ibm.spss.hive.serde2.xml.XmlInputFormat'
OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.IgnoreKeyTextOutputFormat'
TBLPROPERTIES (
"xmlinput.start"="<Activity",
"xmlinput.end"="</Activity>"
);

select activity from activity1;