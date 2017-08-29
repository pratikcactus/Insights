/*
 * DO NOT EDIT.  THIS FILE IS GENERATED FROM ../../../dist/idl\nsITextToSubURI.idl
 */

#ifndef __gen_nsITextToSubURI_h__
#define __gen_nsITextToSubURI_h__


#ifndef __gen_nsISupports_h__
#include "nsISupports.h"
#endif

/* For IDL files that don't want to include root IDL files. */
#ifndef NS_NO_VTABLE
#define NS_NO_VTABLE
#endif
// {8B042E22-6F87-11d3-B3C8-00805F8A6670}
#define NS_TEXTTOSUBURI_CID { 0x8b042e22, 0x6f87, 0x11d3, { 0xb3, 0xc8, 0x0, 0x80, 0x5f, 0x8a, 0x66, 0x70 } }
#define NS_ITEXTTOSUBURI_CONTRACTID "@mozilla.org/intl/texttosuburi;1"

/* starting interface:    nsITextToSubURI */
#define NS_ITEXTTOSUBURI_IID_STR "8b042e24-6f87-11d3-b3c8-00805f8a6670"

#define NS_ITEXTTOSUBURI_IID \
  {0x8b042e24, 0x6f87, 0x11d3, \
    { 0xb3, 0xc8, 0x00, 0x80, 0x5f, 0x8a, 0x66, 0x70 }}

class NS_NO_VTABLE nsITextToSubURI : public nsISupports {
 public:

  NS_DECLARE_STATIC_IID_ACCESSOR(NS_ITEXTTOSUBURI_IID)

  /* string ConvertAndEscape (in string charset, in wstring text); */
  NS_IMETHOD ConvertAndEscape(const char * charset, const char16_t * text, char * *_retval) = 0;

  /* wstring UnEscapeAndConvert (in string charset, in string text); */
  NS_IMETHOD UnEscapeAndConvert(const char * charset, const char * text, char16_t * *_retval) = 0;

  /* AString unEscapeURIForUI (in ACString aCharset, in AUTF8String aURIFragment); */
  NS_IMETHOD UnEscapeURIForUI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval) = 0;

  /* AString unEscapeNonAsciiURI (in ACString aCharset, in AUTF8String aURIFragment); */
  NS_IMETHOD UnEscapeNonAsciiURI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval) = 0;

};

  NS_DEFINE_STATIC_IID_ACCESSOR(nsITextToSubURI, NS_ITEXTTOSUBURI_IID)

/* Use this macro when declaring classes that implement this interface. */
#define NS_DECL_NSITEXTTOSUBURI \
  NS_IMETHOD ConvertAndEscape(const char * charset, const char16_t * text, char * *_retval) override; \
  NS_IMETHOD UnEscapeAndConvert(const char * charset, const char * text, char16_t * *_retval) override; \
  NS_IMETHOD UnEscapeURIForUI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval) override; \
  NS_IMETHOD UnEscapeNonAsciiURI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval) override; 

/* Use this macro when declaring the members of this interface when the
   class doesn't implement the interface. This is useful for forwarding. */
#define NS_DECL_NON_VIRTUAL_NSITEXTTOSUBURI \
  NS_METHOD ConvertAndEscape(const char * charset, const char16_t * text, char * *_retval); \
  NS_METHOD UnEscapeAndConvert(const char * charset, const char * text, char16_t * *_retval); \
  NS_METHOD UnEscapeURIForUI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval); \
  NS_METHOD UnEscapeNonAsciiURI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval); 

/* Use this macro to declare functions that forward the behavior of this interface to another object. */
#define NS_FORWARD_NSITEXTTOSUBURI(_to) \
  NS_IMETHOD ConvertAndEscape(const char * charset, const char16_t * text, char * *_retval) override { return _to ConvertAndEscape(charset, text, _retval); } \
  NS_IMETHOD UnEscapeAndConvert(const char * charset, const char * text, char16_t * *_retval) override { return _to UnEscapeAndConvert(charset, text, _retval); } \
  NS_IMETHOD UnEscapeURIForUI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval) override { return _to UnEscapeURIForUI(aCharset, aURIFragment, _retval); } \
  NS_IMETHOD UnEscapeNonAsciiURI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval) override { return _to UnEscapeNonAsciiURI(aCharset, aURIFragment, _retval); } 

/* Use this macro to declare functions that forward the behavior of this interface to another object in a safe way. */
#define NS_FORWARD_SAFE_NSITEXTTOSUBURI(_to) \
  NS_IMETHOD ConvertAndEscape(const char * charset, const char16_t * text, char * *_retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->ConvertAndEscape(charset, text, _retval); } \
  NS_IMETHOD UnEscapeAndConvert(const char * charset, const char * text, char16_t * *_retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->UnEscapeAndConvert(charset, text, _retval); } \
  NS_IMETHOD UnEscapeURIForUI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->UnEscapeURIForUI(aCharset, aURIFragment, _retval); } \
  NS_IMETHOD UnEscapeNonAsciiURI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->UnEscapeNonAsciiURI(aCharset, aURIFragment, _retval); } 

#if 0
/* Use the code below as a template for the implementation class for this interface. */

/* Header file */
class nsTextToSubURI : public nsITextToSubURI
{
public:
  NS_DECL_ISUPPORTS
  NS_DECL_NSITEXTTOSUBURI

  nsTextToSubURI();

private:
  ~nsTextToSubURI();

protected:
  /* additional members */
};

/* Implementation file */
NS_IMPL_ISUPPORTS(nsTextToSubURI, nsITextToSubURI)

nsTextToSubURI::nsTextToSubURI()
{
  /* member initializers and constructor code */
}

nsTextToSubURI::~nsTextToSubURI()
{
  /* destructor code */
}

/* string ConvertAndEscape (in string charset, in wstring text); */
NS_IMETHODIMP nsTextToSubURI::ConvertAndEscape(const char * charset, const char16_t * text, char * *_retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* wstring UnEscapeAndConvert (in string charset, in string text); */
NS_IMETHODIMP nsTextToSubURI::UnEscapeAndConvert(const char * charset, const char * text, char16_t * *_retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* AString unEscapeURIForUI (in ACString aCharset, in AUTF8String aURIFragment); */
NS_IMETHODIMP nsTextToSubURI::UnEscapeURIForUI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* AString unEscapeNonAsciiURI (in ACString aCharset, in AUTF8String aURIFragment); */
NS_IMETHODIMP nsTextToSubURI::UnEscapeNonAsciiURI(const nsACString & aCharset, const nsACString & aURIFragment, nsAString & _retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* End of implementation class template. */
#endif


#endif /* __gen_nsITextToSubURI_h__ */
