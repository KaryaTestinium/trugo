Specification Heading
=====================
Created by karya.boyraz on 27.02.2024

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
Table: fakerUser.csv

Tüm zorunlu alanlar doldurulmadığında hata mesajı gösterilmeli
----------------
*Click button "Hesap Oluştur"
*Click button "Hesap Oluştur"
*Check element existence "İsim alanı boş geçilemez. Lütfen isminizi giriniz"
*Check element existence "Soyisim alanı boş geçilemez. Lütfen soyisminizi giriniz"
*Check element existence "Bu geçersiz bir telefon numarası. Lütfen kontrol edip tekrar deneyin."
*Check element existence "Bu geçersiz bir e-posta adresi. Lütfen kontrol edip tekrar deneyin."


Aydınlatma Metni gösterilmeli
----------------
*Click button "Hesap Oluştur"
*Click button "Aydınlatma Metni"
*Check element existence "Aydınlatma Metni"
*Check element existence "Trugo Akıllı Şarj Çözümleri Sanayi ve Ticaret A.Ş."


Üyelik Sözleşmesi gösterilmeli
----------------
*Click button "Hesap Oluştur"
*Click button "Üyelik Sözleşmesi"
*Check element existence "TRUGO ÜYELİK SÖZLEŞMESİ"


Daha önceden kayıt edilmiş bir e-posta adresi ile kayıt olunmaya çalışıldığında hata mesajı gösterilmeli
----------------
* Click button "Hesap Oluştur"
* Component Input Write Text <Name> to this element "İsim"
* Component Input Write Text <Surname> to this element "Soyisim"
* Component Input Write Text <PhoneNumber> to this element "Telefon"
* Component Input Write Text <registeredEmail> to this element "E-posta"
* Click button "Hesap Oluştur"
* Check element existence "Bu e-posta zaten kullanılıyor. Lütfen başka bir tane deneyin."


Error message should be displayed when trying to register with a previously registered phone number
----------------
* Click button "Hesap Oluştur"
* Component Input Write Text <Name> to this element "İsim"
* Component Input Write Text <Surname> to this element "Soyisim"
* Component Input Write Text <registeredPhone> to this element "Telefon"
* Component Input Write Text <Email> to this element "E-posta"
* Click button "Hesap Oluştur"
* Check element existence "Bu numara zaten kullanılıyor. Lütfen başka bir tane deneyin."


Successful registration when all mandatory fields are filled in
----------------
* Click button "Hesap Oluştur"
* Component Input Write Text <Name> to this element "İsim"
* Component Input Write Text <Surname> to this element "Soyisim"
* Component Input Write Text <PhoneNumber> to this element "Telefon"
* Component Input Write Text <Email> to this element "E-posta"
* Click button "Hesap Oluştur"
* Write OTP code
* Check element existence "Telefon numaranızı başarıyla doğruladınız"
* Click button "E-posta Adresimi Doğrula"
* Check element existence "E-posta adresinize bir doğrulama bağlantısı gönderdik"
* Verify email
* Check element existence "E-posta adresinizi başarıyla doğruladınız"
* Click button "Hemen Başla"
* Check element existence "Hesap Oluştur"