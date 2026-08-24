#include <jni.h>

extern "C" JNIEXPORT jstring JNICALL
Java_chat_progressive_app_pcore_PcoreBridge_ping(JNIEnv* env, jobject) {
    return env->NewStringUTF("ok");
}
