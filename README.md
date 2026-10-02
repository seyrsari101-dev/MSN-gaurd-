# MSN-GUARD+ (starter project)

این پروژه برای ساخت نسخهٔ مستقل و ارتقایافته بر پایهٔ APK مرجع شما آماده شده است.

## چیزی که داخل پروژه قرار گرفته
- 430 ورودی `server_entries.txt` استخراج‌شده از APK مرجع
- native libraries همان ABI `arm64-v8a` شامل Xray/AnyTLS/Psiphon/tun2socks/obfs4/Tor/Aether
- UI اولیه Android
- درخواست مجوز Android VPN
- Repository برای خواندن سرورها

## نکته مهم
JNI APIهای NativeCore به package/class اصلی `com.msnguard.vpn` وابسته‌اند. برای اتصال واقعی به native core باید bridge را با امضاهای اصلی بازسازی یا native exports را به package جدید map کرد. این کار عمداً جدا نگه داشته شده تا قبل از اتصال، یک TUN سیاه‌چاله ساخته نشود و اینترنت دستگاه قطع نشود.

## build
در Android Studio پروژه را باز کنید و با Android Gradle Plugin 8.13+ و SDK 35 build کنید.

## هدف نسخه بعد
- NativeCore bridge واقعی
- انتخاب سریع‌ترین سرور از همین 430 ورودی
- health check
- kill switch
- split tunneling
- DNS leak protection
- نمایش IP/DNS و مصرف ترافیک

## Build from an Android phone

See `PHONE_BUILD.md`. A GitHub Actions workflow is included at `.github/workflows/build-apk.yml` so the project can be built without a PC.
