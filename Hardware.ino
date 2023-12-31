#include <SPI.h>
#include <MFRC522.h>
#include <ESP8266WiFi.h>  // For ESP8266
// #include <WiFi.h>      // For ESP32

const char* ssid = "Kcybgxu";
const char* password = "helloworld";
const char* serverIP = "192.168.219.180";
const int serverPort = 12345;  // Use the port number your server is listening on

#define SS_PIN D8
#define RST_PIN D0

MFRC522 mfrc522(SS_PIN, RST_PIN);  // Define the RFID module pins

void setup() {
  Serial.begin(9600);

  initializeWifi();

  SPI.begin();
  mfrc522.PCD_Init();  // Initialize the RFID module
  Serial.println("RFID reader initialized");

}
void initializeWifi(){
  // Connect to Wi-Fi
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");
}
void recieveRFID(){
  String cardUID = "";
  if (mfrc522.PICC_IsNewCardPresent() && mfrc522.PICC_ReadCardSerial()) {
    for (byte i = 0; i < mfrc522.uid.size; i++) {
      cardUID.concat(String(mfrc522.uid.uidByte[i], HEX));
    }
    Serial.println(cardUID);
    sendUIDtoServer(cardUID);

    mfrc522.PICC_HaltA();
    mfrc522.PCD_StopCrypto1();
    delay(1000);
  }
}
void sendUIDtoServer(String UID){
  WiFiClient client;
  // Connect to the server
  if (client.connect(serverIP, serverPort)) {
    Serial.println("Connected to server");
    client.println(UID);
    //Do you want to close the client connection
    client.stop();
    Serial.println("Connection Closed");
    delay(1000);
  }
  else{
    Serial.println("Connection with the server Failed");
  }

}
void loop() {
  recieveRFID();
}
