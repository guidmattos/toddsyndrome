{\rtf1\ansi\ansicpg1252\cocoartf1348\cocoasubrtf170
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural

\f0\fs24 \cf0 Todd\'92s Syndrome Project\
\
	The project is done for Android and contains the following packages:\
		- activity -> Has all the activities of the app, which are responsible to control the flow and to present the proper information in the app screens.\
		- adapter -> Contain the HistoryAdapter class that materialize the views for the HistoryActivity.\
		- logic -> Responsible for all the logic about giving the final probability of Todd\'92s Syndrome according to the requirements specified in the e-mail.\
		- model -> Has the Patient class, used as the only table of the database to keep the patient\'92s informations (I used ActiveAndroid to persist the model object).\
\
\
API\
Endpoint: www.mozio.com\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural
\cf0 Method: POST\
Path: /login\
Request (Content-type application/json): (Header Authorization with access token)\
\{\
	\'93email\'94:\'94example@example.com\'94,\
	\'93password\'94:\'94123\'94\
\}\
Response (Content-type application/json):\
Status Code: 200\
\{\}\
Status Code: 401\
\{\
	\'93message\'94:\'94Unauthorized\'94\
\}\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural
\cf0 Method: GET\
Path: /patients\
Request (Content-type application/json): (Header Authorization with access token)\
\{\}\
Response (Content-type application/json):\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural
\cf0 Status Code: 200\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural
\cf0 \{\
	\'93patients\'94:\
	[ \{\
		\'93name\'94:\'94Example Name\'94,\
		\'93age\'94:16,\
		\'93gender\'94:\'94Male\'94,\
		\'93has_migraines\'94:true,\
		\'93used_drugs\'94:false\
	\},\
	\'85\
	]\
\}\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural
\cf0 Status Code: 401\
\{\
	\'93message\'94:\'94Unauthorized\'94\
\}\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural
\cf0 \
\
Method: POST\
Path: /patients\
Request (Content-type application/json): (Header Authorization with access token)\
\{\
	\'93patient\'94: \
	\{\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural
\cf0 		\'93name\'94:\'94Example Name\'94,\
		\'93age\'94:25,\
		\'93gender\'94:\'94Female\'94,\
		\'93has_migraines\'94:false,\
		\'93used_drugs\'94:true\
	\}\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural
\cf0 \}\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural
\cf0 Response (Content-type application/json):\
Status Code: 200\
\{\}\
Status Code: 401\
\{\
	\'93message\'94:\'94Unauthorized\'94\
\}\
}