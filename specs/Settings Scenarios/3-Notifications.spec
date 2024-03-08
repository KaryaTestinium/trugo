Specification Heading
=====================
Created by karya.boyraz on 28.02.2024

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

Table: fakerUser.csv

* Login <PhoneNumber> number and navigate to settings
* Click button "NotificationSettings"
     
Check SMS switch buttons functionality
----------------
*Switch button click "SMS" make status "true"
*Check switch status "SMS" must be "true"
*Switch button click "SMS" make status "false"
*Check switch status "SMS" must be "false"

Check E-posta switch buttons functionality
----------------
*Switch button click "E-posta" make status "true"
*Check switch status "E-posta" must be "true"
*Switch button click "E-posta" make status "false"
*Check switch status "E-posta" must be "false"

Check App Notifications switch buttons functionality
----------------
*Switch button click "Uygulama(anlık ve uygulama içi bildirimler)" make status "true"
*Check switch status "Uygulama(anlık ve uygulama içi bildirimler)" must be "true"
*Switch button click "Uygulama(anlık ve uygulama içi bildirimler)" make status "false"
*Click button "Bildirimleri Kapat"

Check App Notifications switch buttons assertion messages
----------------
*Switch button click "Uygulama(anlık ve uygulama içi bildirimler)" make status "true"
*Switch button click "Uygulama(anlık ve uygulama içi bildirimler)" make status "false"
*Check element existence "Bildirimleri kapatmanız önemli konularda size ulaşmamızı engeller" must be "visible"
*Check element existence "Ceza bedelleri, bilgilendirmeler ve pek çok konuda size zamanında bilgi veremeyeceğiz." must be "visible"
*Check element existence "Yine de devam etmek istiyor musunuz?" must be "visible"
*Click button "Vazgeç"
*Check switch status "Uygulama(anlık ve uygulama içi bildirimler)" must be "true"
*Switch button click "Uygulama(anlık ve uygulama içi bildirimler)" make status "false"
*Click button "Bildirimleri Kapat"
*Check switch status "Uygulama(anlık ve uygulama içi bildirimler)" must be "false"

Check App Notifications sub-switch buttons functionality
----------------
*Switch button click "Uygulama(anlık ve uygulama içi bildirimler)" make status "true"
*Check switch clickable status "Yeni bir istasyon hizmete girdiğinde bildirim gönder" must be "enabled"
*Check switch clickable status "Şarj işlemiyle ilgili bildirim gönder. (Uyarı ve ikazlar içerdiği için önerilir.)" must be "enabled"
*Switch button click "Uygulama(anlık ve uygulama içi bildirimler)" make status "false"
*Check switch clickable status "Yeni bir istasyon hizmete girdiğinde bildirim gönder" must be "disabled"
*Check switch clickable status "Şarj işlemiyle ilgili bildirim gönder. (Uyarı ve ikazlar içerdiği için önerilir.)" must be "disabled"

Check New Stations switch buttons functionality
----------------
*Switch button click "Yeni bir istasyon hizmete girdiğinde bildirim gönder" make status "true"
*Check switch status "Yeni bir istasyon hizmete girdiğinde bildirim gönder" must be "true"
*Switch button click "Yeni bir istasyon hizmete girdiğinde bildirim gönder" make status "false"
*Check switch status "Yeni bir istasyon hizmete girdiğinde bildirim gönder" must be "false"

Check Charge Notifications switch buttons functionality
----------------
*Switch button click "Şarj işlemiyle ilgili bildirim gönder. (Uyarı ve ikazlar içerdiği için önerilir.)" make status "true"
*Check switch status "Şarj işlemiyle ilgili bildirim gönder. (Uyarı ve ikazlar içerdiği için önerilir.)" must be "true"
*Switch button click "Şarj işlemiyle ilgili bildirim gönder. (Uyarı ve ikazlar içerdiği için önerilir.)" make status "false"
*Check switch status "Şarj işlemiyle ilgili bildirim gönder. (Uyarı ve ikazlar içerdiği için önerilir.)" must be "false"