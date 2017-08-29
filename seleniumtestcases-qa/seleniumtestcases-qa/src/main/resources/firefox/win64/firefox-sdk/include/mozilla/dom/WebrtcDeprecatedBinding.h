/* THIS FILE IS AUTOGENERATED FROM WebrtcDeprecated.webidl BY Codegen.py - DO NOT EDIT */

#ifndef mozilla_dom_WebrtcDeprecatedBinding_h
#define mozilla_dom_WebrtcDeprecatedBinding_h

#include "RTCIceCandidateBinding.h"
#include "RTCPeerConnectionBinding.h"
#include "RTCSessionDescriptionBinding.h"
#include "js/RootingAPI.h"
#include "jspubtd.h"
#include "mozilla/ErrorResult.h"
#include "mozilla/dom/BindingDeclarations.h"
#include "mozilla/dom/CallbackInterface.h"
#include "mozilla/dom/Nullable.h"
#include "mozilla/dom/ToJSValue.h"
#include "nsWeakReference.h"

namespace mozilla {
namespace dom {

struct NativePropertyHooks;
class ProtoAndIfaceCache;
struct RTCConfiguration;
struct RTCIceCandidateInit;
struct RTCSessionDescriptionInit;
class mozRTCIceCandidate;
struct mozRTCIceCandidateAtoms;
class mozRTCPeerConnection;
struct mozRTCPeerConnectionAtoms;
class mozRTCSessionDescription;
struct mozRTCSessionDescriptionAtoms;

} // namespace dom
} // namespace mozilla

namespace mozilla {
namespace dom {

namespace mozRTCIceCandidateBinding {

  typedef mozilla::dom::mozRTCIceCandidate NativeType;

  // We declare this as an array so that retrieving a pointer to this
  // binding's property hooks only requires compile/link-time resolvable
  // address arithmetic.  Declaring it as a pointer instead would require
  // doing a run-time load to fetch a pointer to this binding's property
  // hooks.  And then structures which embedded a pointer to this structure
  // would require a run-time load for proper initialization, which would
  // then induce static constructors.  Lots of static constructors.
  extern const NativePropertyHooks sNativePropertyHooks[];

  JSObject*
  DefineDOMInterface(JSContext* aCx, JS::Handle<JSObject*> aGlobal, JS::Handle<jsid> id, bool aDefineOnGlobal);

  bool
  ConstructorEnabled(JSContext* aCx, JS::Handle<JSObject*> aObj);

  const JSClass*
  GetJSClass();

  bool
  Wrap(JSContext* aCx, mozilla::dom::mozRTCIceCandidate* aObject, nsWrapperCache* aCache, JS::Handle<JSObject*> aGivenProto, JS::MutableHandle<JSObject*> aReflector);

  template <class T>
  inline JSObject* Wrap(JSContext* aCx, T* aObject, JS::Handle<JSObject*> aGivenProto)
  {
    JS::Rooted<JSObject*> reflector(aCx);
    return Wrap(aCx, aObject, aObject, aGivenProto, &reflector) ? reflector.get() : nullptr;
  }

  void
  CreateInterfaceObjects(JSContext* aCx, JS::Handle<JSObject*> aGlobal, ProtoAndIfaceCache& aProtoAndIfaceCache, bool aDefineOnGlobal);

  JS::Handle<JSObject*>
  GetProtoObjectHandle(JSContext* aCx, JS::Handle<JSObject*> aGlobal);

  JS::Handle<JSObject*>
  GetConstructorObjectHandle(JSContext* aCx, JS::Handle<JSObject*> aGlobal, bool aDefineOnGlobal = true);

  JSObject*
  GetConstructorObject(JSContext* aCx, JS::Handle<JSObject*> aGlobal);

} // namespace mozRTCIceCandidateBinding



namespace mozRTCPeerConnectionBinding {

  typedef mozilla::dom::mozRTCPeerConnection NativeType;

  // We declare this as an array so that retrieving a pointer to this
  // binding's property hooks only requires compile/link-time resolvable
  // address arithmetic.  Declaring it as a pointer instead would require
  // doing a run-time load to fetch a pointer to this binding's property
  // hooks.  And then structures which embedded a pointer to this structure
  // would require a run-time load for proper initialization, which would
  // then induce static constructors.  Lots of static constructors.
  extern const NativePropertyHooks sNativePropertyHooks[];

  JSObject*
  DefineDOMInterface(JSContext* aCx, JS::Handle<JSObject*> aGlobal, JS::Handle<jsid> id, bool aDefineOnGlobal);

  bool
  ConstructorEnabled(JSContext* aCx, JS::Handle<JSObject*> aObj);

  const JSClass*
  GetJSClass();

  bool
  Wrap(JSContext* aCx, mozilla::dom::mozRTCPeerConnection* aObject, nsWrapperCache* aCache, JS::Handle<JSObject*> aGivenProto, JS::MutableHandle<JSObject*> aReflector);

  template <class T>
  inline JSObject* Wrap(JSContext* aCx, T* aObject, JS::Handle<JSObject*> aGivenProto)
  {
    JS::Rooted<JSObject*> reflector(aCx);
    return Wrap(aCx, aObject, aObject, aGivenProto, &reflector) ? reflector.get() : nullptr;
  }

  void
  CreateInterfaceObjects(JSContext* aCx, JS::Handle<JSObject*> aGlobal, ProtoAndIfaceCache& aProtoAndIfaceCache, bool aDefineOnGlobal);

  JS::Handle<JSObject*>
  GetProtoObjectHandle(JSContext* aCx, JS::Handle<JSObject*> aGlobal);

  JS::Handle<JSObject*>
  GetConstructorObjectHandle(JSContext* aCx, JS::Handle<JSObject*> aGlobal, bool aDefineOnGlobal = true);

  JSObject*
  GetConstructorObject(JSContext* aCx, JS::Handle<JSObject*> aGlobal);

} // namespace mozRTCPeerConnectionBinding



namespace mozRTCSessionDescriptionBinding {

  typedef mozilla::dom::mozRTCSessionDescription NativeType;

  // We declare this as an array so that retrieving a pointer to this
  // binding's property hooks only requires compile/link-time resolvable
  // address arithmetic.  Declaring it as a pointer instead would require
  // doing a run-time load to fetch a pointer to this binding's property
  // hooks.  And then structures which embedded a pointer to this structure
  // would require a run-time load for proper initialization, which would
  // then induce static constructors.  Lots of static constructors.
  extern const NativePropertyHooks sNativePropertyHooks[];

  JSObject*
  DefineDOMInterface(JSContext* aCx, JS::Handle<JSObject*> aGlobal, JS::Handle<jsid> id, bool aDefineOnGlobal);

  bool
  ConstructorEnabled(JSContext* aCx, JS::Handle<JSObject*> aObj);

  const JSClass*
  GetJSClass();

  bool
  Wrap(JSContext* aCx, mozilla::dom::mozRTCSessionDescription* aObject, nsWrapperCache* aCache, JS::Handle<JSObject*> aGivenProto, JS::MutableHandle<JSObject*> aReflector);

  template <class T>
  inline JSObject* Wrap(JSContext* aCx, T* aObject, JS::Handle<JSObject*> aGivenProto)
  {
    JS::Rooted<JSObject*> reflector(aCx);
    return Wrap(aCx, aObject, aObject, aGivenProto, &reflector) ? reflector.get() : nullptr;
  }

  void
  CreateInterfaceObjects(JSContext* aCx, JS::Handle<JSObject*> aGlobal, ProtoAndIfaceCache& aProtoAndIfaceCache, bool aDefineOnGlobal);

  JS::Handle<JSObject*>
  GetProtoObjectHandle(JSContext* aCx, JS::Handle<JSObject*> aGlobal);

  JS::Handle<JSObject*>
  GetConstructorObjectHandle(JSContext* aCx, JS::Handle<JSObject*> aGlobal, bool aDefineOnGlobal = true);

  JSObject*
  GetConstructorObject(JSContext* aCx, JS::Handle<JSObject*> aGlobal);

} // namespace mozRTCSessionDescriptionBinding



class mozRTCIceCandidateJSImpl : public CallbackInterface
{
public:
  explicit inline mozRTCIceCandidateJSImpl(JSContext* aCx, JS::Handle<JSObject*> aCallback, nsIGlobalObject* aIncumbentGlobal)
    : CallbackInterface(aCx, aCallback, aIncumbentGlobal)
  {
  }

  void __Init(const RTCIceCandidateInit& candidateInitDict, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  inline bool
  operator==(const mozRTCIceCandidateJSImpl& aOther) const
  {
    return CallbackInterface::operator==(aOther);
  }

private:
  static bool
  InitIds(JSContext* cx, mozRTCIceCandidateAtoms* atomsCache);
};


class mozRTCIceCandidate final : public mozilla::dom::RTCIceCandidate
{
public:
  NS_DECL_ISUPPORTS_INHERITED
  NS_DECL_CYCLE_COLLECTION_CLASS_INHERITED(mozRTCIceCandidate, mozilla::dom::RTCIceCandidate)

private:
  RefPtr<mozRTCIceCandidateJSImpl> mImpl;
  nsCOMPtr<nsISupports> mParent;

public:
  mozRTCIceCandidate(JS::Handle<JSObject*> aJSImplObject, nsIGlobalObject* aParent);

private:
  ~mozRTCIceCandidate();

public:
  nsISupports* GetParentObject() const;

  virtual JSObject* WrapObject(JSContext* aCx, JS::Handle<JSObject*> aGivenProto) override;

  static already_AddRefed<mozRTCIceCandidate> Constructor(const GlobalObject& global, JSContext* cx, const RTCIceCandidateInit& candidateInitDict, ErrorResult& aRv);

  static bool
  _Create(JSContext* cx, unsigned argc, JS::Value* vp);
};


class mozRTCPeerConnectionJSImpl : public CallbackInterface
{
public:
  explicit inline mozRTCPeerConnectionJSImpl(JSContext* aCx, JS::Handle<JSObject*> aCallback, nsIGlobalObject* aIncumbentGlobal)
    : CallbackInterface(aCx, aCallback, aIncumbentGlobal)
  {
  }

  void __Init(const RTCConfiguration& configuration, const Optional<JS::Handle<JSObject*>>& constraints, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  inline bool
  operator==(const mozRTCPeerConnectionJSImpl& aOther) const
  {
    return CallbackInterface::operator==(aOther);
  }

private:
  static bool
  InitIds(JSContext* cx, mozRTCPeerConnectionAtoms* atomsCache);
};


class mozRTCPeerConnection final : public mozilla::dom::RTCPeerConnection
{
public:
  NS_DECL_ISUPPORTS_INHERITED
  NS_DECL_CYCLE_COLLECTION_CLASS_INHERITED(mozRTCPeerConnection, mozilla::dom::RTCPeerConnection)

private:
  RefPtr<mozRTCPeerConnectionJSImpl> mImpl;
  nsCOMPtr<nsISupports> mParent;

public:
  mozRTCPeerConnection(JS::Handle<JSObject*> aJSImplObject, nsIGlobalObject* aParent);

private:
  ~mozRTCPeerConnection();

public:
  nsISupports* GetParentObject() const;

  virtual JSObject* WrapObject(JSContext* aCx, JS::Handle<JSObject*> aGivenProto) override;

  static already_AddRefed<mozRTCPeerConnection> Constructor(const GlobalObject& global, JSContext* cx, const RTCConfiguration& configuration, const Optional<JS::Handle<JSObject*>>& constraints, ErrorResult& aRv);

  static bool
  _Create(JSContext* cx, unsigned argc, JS::Value* vp);
};


class mozRTCSessionDescriptionJSImpl : public CallbackInterface
{
public:
  explicit inline mozRTCSessionDescriptionJSImpl(JSContext* aCx, JS::Handle<JSObject*> aCallback, nsIGlobalObject* aIncumbentGlobal)
    : CallbackInterface(aCx, aCallback, aIncumbentGlobal)
  {
  }

  void __Init(const RTCSessionDescriptionInit& descriptionInitDict, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  inline bool
  operator==(const mozRTCSessionDescriptionJSImpl& aOther) const
  {
    return CallbackInterface::operator==(aOther);
  }

private:
  static bool
  InitIds(JSContext* cx, mozRTCSessionDescriptionAtoms* atomsCache);
};


class mozRTCSessionDescription final : public mozilla::dom::RTCSessionDescription
{
public:
  NS_DECL_ISUPPORTS_INHERITED
  NS_DECL_CYCLE_COLLECTION_CLASS_INHERITED(mozRTCSessionDescription, mozilla::dom::RTCSessionDescription)

private:
  RefPtr<mozRTCSessionDescriptionJSImpl> mImpl;
  nsCOMPtr<nsISupports> mParent;

public:
  mozRTCSessionDescription(JS::Handle<JSObject*> aJSImplObject, nsIGlobalObject* aParent);

private:
  ~mozRTCSessionDescription();

public:
  nsISupports* GetParentObject() const;

  virtual JSObject* WrapObject(JSContext* aCx, JS::Handle<JSObject*> aGivenProto) override;

  static already_AddRefed<mozRTCSessionDescription> Constructor(const GlobalObject& global, JSContext* cx, const RTCSessionDescriptionInit& descriptionInitDict, ErrorResult& aRv);

  static bool
  _Create(JSContext* cx, unsigned argc, JS::Value* vp);
};


} // namespace dom
} // namespace mozilla

#endif // mozilla_dom_WebrtcDeprecatedBinding_h
