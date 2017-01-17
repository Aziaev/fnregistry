<?xml version='1.0' encoding='UTF-8'?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"
            xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
            xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">
    <S:Header>
        <wsse:Security S:actor="http://smev.gosuslugi.ru/actors/recipient">
            <wsse:BinarySecurityToken
                    EncodingType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary"
                    ValueType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3"
                    wsu:Id="CertId-AD8E49182E5E889B61148463294851670982950">
                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
            </wsse:BinarySecurityToken>
            <ds:Signature xmlns:ds="http://www.w3.org/2000/09/xmldsig#" Id="Signature-23661037">
                <ds:SignedInfo>
                    <ds:CanonicalizationMethod Algorithm="http://www.w3.org/2001/10/xml-exc-c14n#"/>
                    <ds:SignatureMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#gostr34102001-gostr3411"/>
                    <ds:Reference URI="#ID-c6e79466-f5be-4568-a8f7-39084512aff0">
                        <ds:Transforms>
                            <ds:Transform Algorithm="http://www.w3.org/2001/10/xml-exc-c14n#"/>
                        </ds:Transforms>
                        <ds:DigestMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#gostr3411"/>
                        <ds:DigestValue>buO5iaFo6tELvCXhM/Av3WOsC+1oV9IwFv+OAK25+9I=</ds:DigestValue>
                    </ds:Reference>
                    <ds:Reference URI="#body">
                        <ds:Transforms>
                            <ds:Transform Algorithm="http://www.w3.org/2001/10/xml-exc-c14n#"/>
                        </ds:Transforms>
                        <ds:DigestMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#gostr3411"/>
                        <ds:DigestValue>chO2maTrELq/FMiqhnBG67RxUtrks8pDJrGXpr+44UU=</ds:DigestValue>
                    </ds:Reference>
                </ds:SignedInfo>
                <ds:SignatureValue>
                    HSwXuDR+e1fGVQJttJntrOGlnrkt+c3j5X6dQ1Upul4yoR1iz3v+guWtz2kt+ETkcWOtrBq+d2OB
                    Fy4aOgnG9w==
                </ds:SignatureValue>
                <ds:KeyInfo Id="KeyId-AD8E49182E5E889B61148463294851670982951">
                    <wsse:SecurityTokenReference wsu:Id="STRId-AD8E49182E5E889B61148463294851670982952">
                        <wsse:Reference URI="#CertId-AD8E49182E5E889B61148463294851670982950"
                                        ValueType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3"/>
                    </wsse:SecurityTokenReference>
                </ds:KeyInfo>
            </ds:Signature>
        </wsse:Security>
        <wsse:Security S:actor="http://smev.gosuslugi.ru/actors/smev">
            <ds:Signature xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                <ds:SignedInfo>
                    <ds:CanonicalizationMethod Algorithm="http://www.w3.org/2001/10/xml-exc-c14n#"/>
                    <ds:SignatureMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#gostr34102001-gostr3411"/>
                    <ds:Reference URI="#body">
                        <ds:Transforms>
                            <ds:Transform Algorithm="http://www.w3.org/2001/10/xml-exc-c14n#"/>
                        </ds:Transforms>
                        <ds:DigestMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#gostr3411"/>
                        <ds:DigestValue>chO2maTrELq/FMiqhnBG67RxUtrks8pDJrGXpr+44UU=</ds:DigestValue>
                    </ds:Reference>
                </ds:SignedInfo>
                <ds:SignatureValue>
                    pOkHG5H27mwKE2VvtsRHL0z7Fdi53o3FHp16vEHI/UXqZpfnlVBuDCOsDJ669oNzR/sCyQd2Isn8
                    yA8ANteuvQ==
                </ds:SignatureValue>
                <ds:KeyInfo>
                    <wsse:SecurityTokenReference>
                        <wsse:Reference URI="#FNSCertificate"/>
                    </wsse:SecurityTokenReference>
                </ds:KeyInfo>
            </ds:Signature>
            <wsse:BinarySecurityToken
                    EncodingType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary"
                    ValueType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3"
                    wsu:Id="FNSCertificate">
                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
            </wsse:BinarySecurityToken>
        </wsse:Security>
        <smev:Header xmlns:smev="http://smev.gosuslugi.ru/rev111111" wsu:Id="ID-c6e79466-f5be-4568-a8f7-39084512aff0">
            <smev:NodeId>99</smev:NodeId>
            <smev:MessageId>709af10d-f6d5-4c3b-a0ab-eef74bc5143e</smev:MessageId>
            <smev:TimeStamp>2017-01-17T09:02:28.516+03:00</smev:TimeStamp>
            <smev:MessageClass>RESPONSE</smev:MessageClass>
        </smev:Header>
    </S:Header>
    <S:Body wsu:Id="body">
        <ws:queryINNFLFIODRResponse xmlns:ws="http://ws.unisoft/">
            <smev:Message xmlns:smev="http://smev.gosuslugi.ru/rev111111">
                <smev:Sender>
                    <smev:Code>FNSR01001</smev:Code>
                    <smev:Name>ФНС России</smev:Name>
                </smev:Sender>
                <smev:Recipient>
                    <smev:Code>FNSR01001</smev:Code>
                    <smev:Name>ФНС России</smev:Name>
                </smev:Recipient>
                <smev:Originator>
                    <smev:Code>FNSR01001</smev:Code>
                    <smev:Name>ФНС России</smev:Name>
                </smev:Originator>
                <smev:TypeCode>GSRV</smev:TypeCode>
                <smev:Status>ACCEPT</smev:Status>
                <smev:Date>2017-01-17T06:01:55Z</smev:Date>
                <smev:ExchangeType>2</smev:ExchangeType>
                <smev:RequestIdRef>709af10d-f6d5-4c3b-a0ab-eef74bc5143e</smev:RequestIdRef>
                <smev:OriginRequestIdRef>709af10d-f6d5-4c3b-a0ab-eef74bc5143e</smev:OriginRequestIdRef>
                <smev:ServiceCode/>
                <smev:CaseNumber/>
                <smev:TestMsg/>
            </smev:Message>
            <smev:MessageData xmlns:smev="http://smev.gosuslugi.ru/rev111111">
                <smev:AppData wsu:Id="fns-AppData">
                    <Документ xmlns="http://ws.unisoft/INNFIODR/Query/Rs" ВерсФорм="4.01">
                        <ИдЗапросФ>1078599</ИдЗапросФ>
                    </Документ>
                </smev:AppData>
            </smev:MessageData>
        </ws:queryINNFLFIODRResponse>
    </S:Body>
</S:Envelope>