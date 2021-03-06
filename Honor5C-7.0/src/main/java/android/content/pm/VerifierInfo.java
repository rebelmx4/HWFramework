package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.security.PublicKey;

public class VerifierInfo implements Parcelable {
    public static final Creator<VerifierInfo> CREATOR = null;
    public final String packageName;
    public final PublicKey publicKey;

    static {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.content.pm.VerifierInfo.<clinit>():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: jadx.core.utils.exceptions.DecodeException:  in method: android.content.pm.VerifierInfo.<clinit>():void
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:46)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:98)
	... 7 more
Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1197)
	at com.android.dx.io.OpcodeInfo.getFormat(OpcodeInfo.java:1212)
	at com.android.dx.io.instructions.DecodedInstruction.decode(DecodedInstruction.java:72)
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:43)
	... 8 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.VerifierInfo.<clinit>():void");
    }

    public VerifierInfo(String packageName, PublicKey publicKey) {
        if (packageName == null || packageName.length() == 0) {
            throw new IllegalArgumentException("packageName must not be null or empty");
        } else if (publicKey == null) {
            throw new IllegalArgumentException("publicKey must not be null");
        } else {
            this.packageName = packageName;
            this.publicKey = publicKey;
        }
    }

    private VerifierInfo(Parcel source) {
        this.packageName = source.readString();
        this.publicKey = (PublicKey) source.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.packageName);
        dest.writeSerializable(this.publicKey);
    }
}
