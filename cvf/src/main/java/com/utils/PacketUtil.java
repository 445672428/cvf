package com.utils;

public class PacketUtil {
	public static byte[] packetCmd(byte cmd) {
		byte key = 0x01;
		byte[] head = new byte[5];
		byte tail = (byte) 0xFE;
		byte sum = 0x01;
		int len = 8;
		byte[] packet = new byte[len];
		byte[] lenBytes = BytesUtil.intToBytes(len);
		head[0] = 0x1c;
		head[1] = 0x55;
		head[2] = lenBytes[2];
		head[3] = lenBytes[3];
		head[4] = key;
		byte[] temp = new byte[3];
		temp[0] = cmd;
		temp[1] = sum;
		temp[2] = tail;
		byte[] encode = BytesUtil.encode(temp, key);
		System.arraycopy(head, 0, packet, 0, head.length);
		System.arraycopy(encode, 0, packet, 5, encode.length);
		return packet;
	}

	public static byte[] packetPrint(byte cmd, byte[] data) {
		byte key = 0x01;
		byte[] head = new byte[5];
		byte tail = (byte) 0xFE;
		int s = 1 + data.length;
		byte[] stemp = BytesUtil.intToBytes(s);
		byte sum = stemp[3];
		int len = 8 + data.length;
		byte[] packet = new byte[len];
		byte[] lenBytes = BytesUtil.intToBytes(len);
		head[0] = 0x1c;
		head[1] = 0x55;
		head[2] = lenBytes[2];
		head[3] = lenBytes[3];
		head[4] = key;

		byte[] temp = new byte[len - 5];
		temp[0] = cmd;
		System.arraycopy(data, 0, temp, 1, data.length);
		temp[temp.length - 2] = sum;
		temp[temp.length - 1] = tail;
		byte[] encode = BytesUtil.encode(temp, key);

		System.arraycopy(head, 0, packet, 0, head.length);
		System.arraycopy(encode, 0, packet, 5, encode.length);
		return packet;
	}

	public static byte[] packetLed(byte cmd, byte color, byte[] data) {
		byte key = 0x01;
		byte[] head = new byte[5];
		byte tail = (byte) 0xFE;
		System.out.println("0xFE-->" + 0xFE);
		int s = 2 + data.length;
		byte[] stemp = BytesUtil.intToBytes(s);
		byte sum = stemp[3];
		int len = 9 + data.length;
		byte[] packet = new byte[len];
		byte[] lenBytes = BytesUtil.intToBytes(len);
		head[0] = 0x1c;
		head[1] = 0x55;
		head[2] = lenBytes[2];
		head[3] = lenBytes[3];
		head[4] = key;

		byte[] temp = new byte[len - 5];
		temp[0] = cmd;
		temp[1] = color;
		System.arraycopy(data, 0, temp, 2, data.length);
		temp[temp.length - 2] = sum;
		temp[temp.length - 1] = tail;
		byte[] encode = BytesUtil.encode(temp, key);
		System.arraycopy(head, 0, packet, 0, head.length);
		System.arraycopy(encode, 0, packet, 5, encode.length);
		return packet;
	}

	public static byte[] unpacket(byte[] buffer) {
		byte[] head = new byte[5];
		System.arraycopy(buffer, 0, head, 0, 5);
		if (head[0] != 0x1c || head[1] != 0x55) {// 帧头信息不对
			return null;
		}
		byte[] lenBytes = { 0x00, 0x00, head[2], head[3] };
		byte key = head[4];
		int len = BytesUtil.bytesToInt(lenBytes);
		byte[] packet = new byte[len];
		System.arraycopy(buffer, 0, packet, 0, len);// 解密前packet
		byte[] temp = new byte[len - 5];
		System.arraycopy(packet, 5, temp, 0, len - 5);// 将加密部分取出放到temp 中
		byte[] decode = BytesUtil.decode(temp, key);// 解密
		if ((byte) 0xFE != decode[decode.length - 1]) {// 帧尾信息不对
			return null;
		}
		byte sum = BytesUtil.intToBytes(len - 7)[3];
		if (sum != decode[decode.length - 2]) {// 校验和不对
			return null;
		}
		System.arraycopy(decode, 0, packet, 5, decode.length);// packet为解密后的整个数据包
		return packet;
	}
}
