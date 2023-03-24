Feature: JDBC ile Database üzerinden veri sorgulama

  #1-) Database üzerinden id numarasi 45 olan customer'in email adres bilgisinin
  # "cibaho4293@fanneat.com" oldugunu dogrulayiniz.
@jdbc
  Scenario:
    * Database ile baglanti kurulur.
    * Query olusturulur.
    * OLusturulan query statement araciligi ile database gonderilir.
    * Statement ile donen veriler dogrulanir.
    * Database baglantisi kapatilir.

