/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.net.NetworkInterface;
/*    */ import java.util.Properties;
/*    */ import java.util.Set;
/*    */ import org.jasypt.encryption.pbe.PBEStringEncryptor;
/*    */ import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
/*    */ import org.jasypt.properties.PropertyValueEncryptionUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CryptoMain
/*    */ {
/*    */   public static void main(String[] args)
/*    */     throws FileNotFoundException, IOException
/*    */   {
/* 20 */     Properties props = new Properties();
/* 21 */     props.load(new FileInputStream(args[0]));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 28 */     PBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
/*    */     
/*    */     NetworkInterface network;
/*    */     NetworkInterface network;
/* 32 */     if (args.length <= 2) {
/* 33 */       network = NetworkInterface.getByName("eth0");
/*    */     } else {
/* 35 */       network = NetworkInterface.getByName(args[2]);
/*    */     }
/*    */     
/* 38 */     byte[] mac = network.getHardwareAddress();
/* 39 */     StringBuilder sb = new StringBuilder();
/* 40 */     for (int i = 0; i < mac.length; i++) {
/* 41 */       sb.append(String.format("%02X%s", new Object[] { Byte.valueOf(mac[i]), i < mac.length - 1 ? "-" : "" }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 49 */     encryptor.setPassword(sb.toString() + "4l14nz4_p4ss_k3y");
/*    */     
/*    */ 
/*    */ 
/* 53 */     Set<String> nombresPropiedades = props.stringPropertyNames();
/* 54 */     for (String nombrePropiedad : nombresPropiedades) {
/* 55 */       String clave = props.getProperty(nombrePropiedad);
/*    */       
/* 57 */       String claveEncriptada = PropertyValueEncryptionUtils.encrypt(clave, encryptor);
/*    */       
/* 59 */       props.setProperty(nombrePropiedad, claveEncriptada);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 64 */     OutputStream os = new FileOutputStream(args[1]);
/* 65 */     props.store(os, "Fichero generado automaticamente");
/*    */   }
/*    */ }


/* Location:              C:\Users\Ricardo\Downloads\CryptoProperties.jar!\CryptoMain.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */