package zyf;

import redis.clients.jedis.Jedis;

/**
* @Author 庄元丰
* @CreateTime 2017年10月18日下午2:58:46
*/
public class Main {
	public static void main(String[] args) {
		Jedis jedis = null ;
		try {
			jedis = new Jedis("localhost");
			System.out.println("服务正在运行:" + jedis.ping());
			jedis.set("name", "hello,world");
			System.out.println(jedis.get("name"));
		}finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}
}
