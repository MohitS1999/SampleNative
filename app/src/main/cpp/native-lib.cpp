#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_samplenative_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++ : )";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jfloatArray JNICALL
Java_com_example_samplenative_MainActivity_floatFromJNI(JNIEnv *env, jobject thiz,
                                                        jfloatArray arr) {
    // TODO: implement floatFromJNI()
    jsize len = (*env).GetArrayLength(arr);
    jfloat  *temp = (*env).GetFloatArrayElements(arr,0);
    jfloatArray result;
    result = env->NewFloatArray(len);
    if (result == NULL) {
        return NULL; /* out of memory error thrown */
    }

    // doubling the array
    for (int i=0;i<len;i++){
        temp[i] = 2 * temp[i];
    }
    env->SetFloatArrayRegion(result,0,len,temp);
    // this is how we can release the memory
    env->ReleaseFloatArrayElements(arr,temp,0);
    return result;
}