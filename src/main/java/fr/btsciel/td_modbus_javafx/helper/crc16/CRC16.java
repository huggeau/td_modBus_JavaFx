package fr.btsciel.td_modbus_javafx.helper.crc16;

public class CRC16 {
    public CRC16() {
    }

    public static int calculCrc16(byte[] octets, int valeurInitiale, int polynomeArbitraire){
        int crc = valeurInitiale;
        int nb_octet_traite = 0;
        byte octetSuivant = octets[0];
        do {
            int octet_traite = octetSuivant;
            crc = crc ^ octet_traite;
            for (int i = 0; i < 8; i++) {
                if(crc % 2 == 1){
                    crc = (crc/2)^polynomeArbitraire;
                }else{
                    crc /= 2;
                }
                nb_octet_traite++;
            }
        }while(nb_octet_traite <= octets.length);
        return crc;
    }
    public static byte[] hexStringByteEnArray(String message){
        int len = message.length();
        byte[] data = new byte[len/2];
        for (int i = 0; i < len; i+=2) {
            data[i/2] = (byte) ((Character.digit(message.charAt(i),16) << 4) +
                    (Character.digit(message.charAt(i+1), 16)));
        }
        return data;
    }
    public static byte[] formatage(String trame){
        trame = trame.trim().replaceAll(" ", "");
        if(trame.length() % 2 == 1){
            return hexStringByteEnArray('0'+trame);
        }else{
            return hexStringByteEnArray(trame);
        }
    }


}
