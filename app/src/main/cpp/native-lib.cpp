#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jfloatArray JNICALL
Java_com_example_getdoubledarray_FloatArrayLib_00024Companion_floatFromJNI(JNIEnv *env,
                                                                           jobject thiz,
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