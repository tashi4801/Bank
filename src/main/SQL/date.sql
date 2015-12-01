------都道府県データ------
DELETE FROM prefectures;
insert into prefectures values('0','--');
insert into prefectures values('1','東京都');
insert into prefectures values('2','埼玉県');
insert into prefectures values('3','千葉県');
insert into prefectures values('4','群馬県');
insert into prefectures values('5','茨城県');
insert into prefectures values('6','山梨県');
insert into prefectures values('7','栃木県');
insert into prefectures values('8','福島県');
insert into prefectures values('9','宮城県');
insert into prefectures values('10','岩手県');
insert into prefectures values('11','秋田県');

------趣味データ------
DELETE FROM hobbys;
insert into hobbys values('0','酒');
insert into hobbys values('1','スポーツ');
insert into hobbys values('2','釣り');
insert into hobbys values('3','山登り');
insert into hobbys values('4','ピクニック');
insert into hobbys values('5','アニメ');
insert into hobbys values('6','アイドル');
insert into hobbys values('7','映画鑑賞');
insert into hobbys values('8','音楽鑑賞');
insert into hobbys values('9','カラオケ');

------性別------
DELETE FROM sex;
insert into sex values('1','男性');
insert into sex values('2','女性');

------ユーザー------
DELETE FROM member;
insert into member (name,password)values('園田','e0906612');
insert into member (name,password)values('sonoda','e0906612');
insert into member (name,password)values('園田','e0906612');
insert into member(name,password) values('sonoda','e0906612');
insert into member(name,password) values('園田','e0906612');
insert into member(name,password) values('園田','e0906612');
insert into member(name,password) values('sonoda','e0906612');
insert into member(name,password) values('園田','e0906612');
insert into member (name,password)values('sonoda','e0906612');
insert into member (name,password)values('園田','e0906612');
insert into member (name,password)values('sonodasonoda','e0906612');
insert into member(name,password) values('園田園田','e0906612');
insert into member(name,password) values('sonodasonoda','e0906612');
insert into member(name,password) values('園田園田','e0906612');
insert into member (name,password)values('sonodasonoda','e0906612');
insert into member(name,password) values('園田園田','e0906612');
insert into member(name,password) values('sonodasonoda','e0906612');
insert into member (name,password)values('園田園田','e0906612');
insert into member(name,password) values('sonodasonoda','e0906612');
insert into member(name,password) values('園田園田','e0906612');
insert into member(name,password) values('sonodasonoda','e0906612');
insert into member (name,password)values('園田園田','e0906612');

-------select文------
select x.xs_id,x.userid,m.name,x.xs_text from xss as x left join member as m on x.userid=m.id;

