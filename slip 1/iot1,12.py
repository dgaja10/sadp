#include <ESP8266WiFi.h>
void setup() {
Serial.begin(115200);
WiFi.disconnect(); 
delay(200); 
Serial.println("***** WiFi Scan Started *****");
}
void loop() {
int n = WiFi.scanNetworks(); 
Serial.println("Scan done");
if (n == 0)
Serial.println("No Network Found");
else
{
Serial.print(n);
Serial.println(" Networks found");
for (int i = 0; i < n; ++i)
{

Serial.print(i + 1); //Sr. No
Serial.print(": ");
Serial.print(WiFi.SSID(i)); //SSID
Serial.print(" (");
Serial.print(WiFi.RSSI(i)); //Signal Strength
Serial.print(") MAC:");
Serial.print(WiFi.BSSIDstr(i));
Serial.println((WiFi.encryptionType(i) == ENC_TYPE_NONE)? " Unsecured" : " Secured" );
delay(10);
}
}
Serial.println("");
delay(6000); // delay 6sec
}