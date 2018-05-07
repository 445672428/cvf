package com.utils;

public class BytesUtil {
	public static byte[] encode(byte[] buf, byte key) {
		byte[] buff = new byte[buf.length];
		if (buf.length > 0) {
			for (int i = 0; i < buf.length; i++) {
				byte temp = (byte) ~buf[i];
				buff[i] = (byte) (temp ^ key);
			}
		}
		return buff;
	}

	public static byte[] decode(byte[] buf, byte key) {
		byte[] buff = new byte[buf.length];
		if (buf.length > 0) {
			for (int i = 0; i < buf.length; i++) {
				byte temp = (byte) (buf[i] ^ key);
				buff[i] = (byte) ~temp;
			}
		}
		return buff;
	}

	public static byte[] intToBytes(int value) {
		byte[] src = new byte[4];
		src[0] = (byte) ((value >> 24) & 0xFF);
		src[1] = (byte) ((value >> 16) & 0xFF);
		src[2] = (byte) ((value >> 8) & 0xFF);
		src[3] = (byte) (value & 0xFF);
		return src;
	}

	public static int bytesToInt(byte[] src) {
		int value;
		value = (int) (((src[0] & 0xFF) << 24) | ((src[1] & 0xFF) << 16)
				| ((src[2] & 0xFF) << 8) | (src[3] & 0xFF));
		return value;
	}

	@Deprecated
	public static int byte2int(byte[] res) {
		// res = InversionByte(res);
		// 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000
		int value = (res[0] & 0xff) | ((res[1] << 8) & 0xff00); // | 表示安位或
		return value;
	}

}
