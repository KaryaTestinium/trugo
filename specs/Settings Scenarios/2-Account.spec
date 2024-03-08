Specification Heading
=====================
Created by karya.boyraz on 27.02.2024

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
Table: fakerUser.csv

* Login <PhoneNumber> number and navigate to settings
* Click button "Account"

Account Check Main page element existence
----------------
* Check element existence "Telefon" must be "visible"
* Check element existence <PhoneNumber> must be "visible"
* Check element existence "E-posta" must be "visible"
* Check element existence <Email> must be "visible"
* Check element existence "Yeni Fatura Adresi" must be "visible"
* Check element existence "Hesabı Sil" must be "visible"

Create a new User Invoice
----------------
* Click button "AddInvoice"
* Click button "Bireysel"
* Component Input Write Text <InvoiceName> to this element "Fatura Başlığı"
* Component Input Write Text <Email> to this element "E-posta Adresi"
* Component Input Write Text <Name> to this element "İsim"
* Component Input Write Text <Surname> to this element "Soyisim"
* Click button for form "Başka bir ülke vatandaşıyım."
* Click button for form "İl"
* Select <City> from dropdown
* Component Input Write Text <Country> to this element "İlçe"
* Component Input Write Text <Plaka> to this element "Plaka"
* Component Input Write Text <Address> to this element "Fatura Adresi"
* Click button "Kaydet"
* Check element existence "Fatura Adresleri" must be "visible"
* Check element existence <InvoiceName> must be "visible"


Create a new Company Invoice
----------------
* Click button "AddInvoice"
* Click button "Kurumsal"
* Component Input Write Text <InvoiceName> to this element "Fatura Başlığı"
* Component Input Write Text <Email> to this element "E-posta Adresi"
* Component Input Write Text <CompanyTitle> to this element "Şirket Ünvanı"
* Component Input Write Text <TaxNo> to this element "Vergi Kimlik No"
* Component Input Write Text <TaxOfficeName> to this element "Vergi Dairesi"
* Click button for form "İl"
* Select <City> from dropdown
* Component Input Write Text <Country> to this element "İlçe"
* Component Input Write Text <Plaka> to this element "Plaka"
* Component Input Write Text <Address> to this element "Fatura Adresi"
* Click button "Kaydet"
* Check element existence "Fatura Adresleri" must be "visible"
* Check element existence <InvoiceName> must be "visible"


Account Leaving Invoice Page Alert Message vazgeç butonu
----------------
//Element için uyarı mesajı kontrolü yapılacak
* Click button "AddInvoice"
* Click button "Bireysel"
* Component Input Write Text <InvoiceName> to this element "Fatura Başlığı"
* Click button "Back"
* Check element existence "uyarımesajı" must be "visible"
* Click button "Vazgeç"
* Check element existence "Fatura Başlığı" must be "visible"

Account Leaving Invoice Page Alert Message tamam butonu
----------------
//Element için uyarı mesajı kontrolü yapılacak
* Click button "AddInvoice"
* Click button "Bireysel"
* Component Input Write Text <InvoiceName> to this element "Fatura Başlığı"
* Click button "Back"
* Check element existence "uyarımesajı" must be "visible"
* Click button "Tamam"
* Check element existence "Fatura Adresleri" must be "visible"


Edit Last Created User Invoice
----------------
* Created  <InvoiceName> invoice click "Edit" button
* Component Input Write Text "randomemailadress@gmail.com" to this element "E-posta adresi"
* Click button for form "Kaydet"
* Check element existence "Fatura Adresleri" must be "visible"
* Created  <InvoiceName> invoice click "Edit" button
* Check element existence "randomemailadress@gmail.com" must be "visible"

Delete Last Created User Invoice try to "Vazgeç" option
----------------
* Created  <InvoiceName> invoice click "Delete" button
* Check element existence "adlı fatura adresinizi silmek üzeresiniz" must be "visible"
* Check element existence "Silme işlemini geri alamayacığınızı lütfen unutmayın" must be "visible"
*Click button "Vazgeç"
* Check element existence <InvoiceName> must be "visible"

Delete Last Created User Invoice try to "Sil" option
----------------
* Created  <InvoiceName> invoice click "Delete" button
* Check element existence "adlı fatura adresinizi silmek üzeresiniz" must be "visible"
* Check element existence "Silme işlemini geri alamayacığınızı lütfen unutmayın" must be "visible"
* Click button "Sil"
* Check element existence <InvoiceName> must be "Not visible"



// TODO: company den bireysele geçiş yapılmaması lazım onun kontrolü yapılacak
// TODO: fatura ismi değiştirilemiyor olması lazım o eklenecek
// TODO: TC vatandaşı olarak da bir fatura adresi eklenmeli


Delete User Profile
----------------
* Login <PhoneNumber> number and navigate to settings
* Click button "Account"
* Click button "Hesabı Sil"
* Click button "Onayla"
* Write text <PhoneNumber> to this element "editText"
* Click button "Oturum Aç"
* Check element existence "Kullanıcı bulunumadı" must be "visible"
