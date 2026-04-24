# 🚀 Debloater — Otimize seu Android

App para remover bloatware de qualquer Android usando Shizuku, sem root.

## 📱 Marcas suportadas
- Xiaomi / POCO / Redmi / HyperOS
- Samsung
- Motorola
- Realme
- OnePlus
- LG
- Sony
- Qualquer Android (pacotes Google genéricos)

## ⬇️ Download
Baixe o APK mais recente em [Releases](../../releases/latest)

## ⚙️ Como usar

### 1. Instale o Shizuku
Baixe na [Play Store](https://play.google.com/store/apps/details?id=moe.shizuku.privileged.api)

### 2. Ative as Opções de Desenvolvedor
- Configurações → Sobre o telefone
- Toque **7 vezes** em Número da versão

### 3. Ative a Depuração USB
- Configurações → Opções de Desenvolvedor → Depuração USB ✅

### 4. Inicie o Shizuku via ADB Wireless
No Termux:
```bash
adb connect 127.0.0.1:5555
```
Ou use o pareamento sem fio dentro do próprio app Shizuku.

### 5. Abra o Debloater
- O app detecta sua marca automaticamente
- Toque em **Como configurar o Shizuku** e conceda a permissão
- Toque em **Iniciar Debloat** 🚀

## 🔄 Restaurar um pacote
Se algo der errado, restaure com:
```bash
adb shell cmd package install-existing com.pacote.aqui
```

## 🛠️ Compilar
```bash
git clone https://github.com/SEU_USUARIO/debloater
cd debloater
./gradlew assembleRelease
```
O APK vai estar em `app/build/outputs/apk/release/`
