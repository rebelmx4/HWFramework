package jcifs.smb;

public class BufferCache {
    private static final int MAX_BUFFERS = 0;
    static Object[] cache;
    private static int freeBuffers;

    static {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: jcifs.smb.BufferCache.<clinit>():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: jadx.core.utils.exceptions.DecodeException:  in method: jcifs.smb.BufferCache.<clinit>():void
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
        throw new UnsupportedOperationException("Method not decompiled: jcifs.smb.BufferCache.<clinit>():void");
    }

    public static byte[] getBuffer() {
        synchronized (cache) {
            byte[] buf;
            if (freeBuffers > 0) {
                for (int i = 0; i < MAX_BUFFERS; i++) {
                    if (cache[i] != null) {
                        buf = (byte[]) cache[i];
                        cache[i] = null;
                        freeBuffers--;
                        return buf;
                    }
                }
            }
            buf = new byte[65535];
            return buf;
        }
    }

    static void getBuffers(SmbComTransaction req, SmbComTransactionResponse rsp) {
        synchronized (cache) {
            req.txn_buf = getBuffer();
            rsp.txn_buf = getBuffer();
        }
    }

    public static void releaseBuffer(byte[] buf) {
        synchronized (cache) {
            if (freeBuffers < MAX_BUFFERS) {
                for (int i = 0; i < MAX_BUFFERS; i++) {
                    if (cache[i] == null) {
                        cache[i] = buf;
                        freeBuffers++;
                        return;
                    }
                }
            }
        }
    }
}
