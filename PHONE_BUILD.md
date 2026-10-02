# ساخت APK فقط با گوشی

ساده‌ترین روش، استفاده از GitHub Actions است؛ گوشی فقط فایل‌ها را به GitHub می‌فرستد و سرور GitHub APK را می‌سازد.

## روش پیشنهادی با Termux

1. Termux را نصب کن.
2. ZIP پروژه را داخل حافظه گوشی استخراج کن.
3. وارد پوشه `MSN-GUARD-PLUS` شو.
4. اجرا کن:

```bash
pkg update
pkg install git
./build-phone.sh
```

5. در GitHub یک repository خالی بساز.
6. URL آن را وقتی اسکریپت خواست وارد کن.
7. برای `git push`، رمز حساب GitHub را وارد نکن؛ GitHub برای HTTPS از Personal Access Token استفاده می‌کند.
8. در صفحه repository برو به **Actions**.
9. Workflow با نام **Build MSN-GUARD+** را باز کن و **Run workflow** بزن.
10. پس از پایان build، بخش **Artifacts** را باز کن و `MSN-GUARD-PLUS-debug-apk` را دانلود کن.
11. ZIP دانلودشده را باز کن و APK را روی گوشی نصب کن.

این روش به کامپیوتر نیاز ندارد. GitHub Actions محیط JDK، Android SDK و Gradle را روی runner آماده می‌کند.

## نکته

APK فعلی هنوز bridge کامل NativeCore/JNI و اتصال واقعی VPN را پیاده نکرده است؛ این workflow فقط همین پروژه فعلی را قابل build می‌کند و آن را به‌عنوان «VPN کامل» معرفی نمی‌کند.
