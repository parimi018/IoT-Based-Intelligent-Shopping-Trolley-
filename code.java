//Libraries included:
#include <Wire.h>
#include <SPI.h>
#include <MFRC522.h>
#include <LiquidCrystal_I2C.h>
//Declaring Variables:
int pr1=0,pr2=0,pr3=0,pr4=0,pr5=0,pr6=0,tot=0,cnt;
int count=0,c1=0,c2=0,c3=0,c4=0,c5=0,c6=0;
String to store Tag UID:
String tagUID = "89 50 E5 7C";
String tagUID1 = "79 3F 1D 85";
String tagUID2 = "A7 55 CA 4D";
String tagUID3 = "F7 E4 40 4E";
String tagUID4 = "A7 9C 1D B3";
String tagUID5 = "0A 56 11 67";
//To Read the RFID Card:
String tag = "";
for (byte j = 0; j < mfrc522.uid.size; j++)
{
tag.concat(String(mfrc522.uid.uidByte[j] < 0x10 ? " 0" : " "));
tag.concat(String(mfrc522.uid.uidByte[j], HEX));
}
14
//To add/remove a product:
if (tag.substring(1) == tagUID)
{
pr1++;
digitalWrite(buz,1);
// Serial.print("Prod-1 of Rs-25");
lcd.setCursor(0,0);
lcd.print("prod-1 of Rs-25 ");
digitalWrite(buz,0);
if(pr1%2==1)
{
digitalWrite(buz,1);
digitalWrite(gled,1);
delay(100);
digitalWrite(gled,0);
digitalWrite(buz,0);
tot=tot+25;
cnt=cnt+1;
}
else
{ digitalWrite(buz,1);
digitalWrite(rled,1);
delay(100);
digitalWrite(rled,0);
digitalWrite(buz,0);
tot=tot-25;
cnt=cnt-1;
}
}
delay(2000);
goto ss;
}
