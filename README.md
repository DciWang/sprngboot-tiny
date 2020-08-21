# sprngboot-tiny
##spring scurity JWT    
###JWT的组成
JWT token的格式：header.payload.signature
header中用于存放签名的生成算法
{"alg": "HS512"}
Copy to clipboardErrorCopied
payload中用于存放用户名、token的生成时间和过期时间
{"sub":"admin","created":1489079981393,"exp":1489684781}
Copy to clipboardErrorCopied
signature为以header和payload生成的签名，一旦header和payload被篡改，验证将失败
//secret为加密算法的密钥
String signature = HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
