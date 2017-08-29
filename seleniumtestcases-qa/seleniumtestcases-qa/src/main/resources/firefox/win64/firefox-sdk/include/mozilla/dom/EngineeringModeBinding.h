/* THIS FILE IS AUTOGENERATED FROM EngineeringMode.webidl BY Codegen.py - DO NOT EDIT */

#ifndef mozilla_dom_EngineeringModeBinding_h
#define mozilla_dom_EngineeringModeBinding_h

#include "js/RootingAPI.h"
#include "jspubtd.h"
#include "mozilla/DOMEventTargetHelper.h"
#include "mozilla/ErrorResult.h"
#include "mozilla/dom/BindingDeclarations.h"
#include "mozilla/dom/CallbackInterface.h"
#include "mozilla/dom/Nullable.h"
#include "mozilla/dom/ToJSValue.h"
#include "nsWeakReference.h"

namespace mozilla {
namespace dom {

class EngineeringMode;
struct EngineeringModeAtoms;
class EventHandlerNonNull;
struct NativePropertyHooks;
class Promise;
class ProtoAndIfaceCache;

} // namespace dom
} // namespace mozilla

namespace mozilla {
namespace dom {

namespace EngineeringModeBinding {

  typedef mozilla::dom::EngineeringMode NativeType;

  JSObject*
  ConstructNavigatorObject(JSContext* aCx, JS::Handle<JSObject*> aObj);

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
  Wrap(JSContext* aCx, mozilla::dom::EngineeringMode* aObject, nsWrapperCache* aCache, JS::Handle<JSObject*> aGivenProto, JS::MutableHandle<JSObject*> aReflector);

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

} // namespace EngineeringModeBinding



class EngineeringModeJSImpl : public CallbackInterface
{
public:
  explicit inline EngineeringModeJSImpl(JSContext* aCx, JS::Handle<JSObject*> aCallback, nsIGlobalObject* aIncumbentGlobal)
    : CallbackInterface(aCx, aCallback, aIncumbentGlobal)
  {
  }

  already_AddRefed<Promise> GetValue(const nsAString& name, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  already_AddRefed<Promise> SetValue(const nsAString& name, const nsAString& value, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  inline bool
  operator==(const EngineeringModeJSImpl& aOther) const
  {
    return CallbackInterface::operator==(aOther);
  }

  already_AddRefed<EventHandlerNonNull> GetOnmessage(ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  void SetOnmessage(EventHandlerNonNull* arg, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

private:
  static bool
  InitIds(JSContext* cx, EngineeringModeAtoms* atomsCache);
};


class EngineeringMode final : public mozilla::DOMEventTargetHelper
{
public:
  NS_DECL_ISUPPORTS_INHERITED
  NS_DECL_CYCLE_COLLECTION_CLASS_INHERITED(EngineeringMode, mozilla::DOMEventTargetHelper)

private:
  RefPtr<EngineeringModeJSImpl> mImpl;
  nsCOMPtr<nsISupports> mParent;

public:
  EngineeringMode(JS::Handle<JSObject*> aJSImplObject, nsIGlobalObject* aParent);

private:
  ~EngineeringMode();

public:
  nsISupports* GetParentObject() const;

  virtual JSObject* WrapObject(JSContext* aCx, JS::Handle<JSObject*> aGivenProto) override;

  // Return a raw pointer here to avoid refcounting, but make sure it's safe (the object should be kept alive by the callee).
  already_AddRefed<Promise> GetValue(const nsAString& name, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  // Return a raw pointer here to avoid refcounting, but make sure it's safe (the object should be kept alive by the callee).
  already_AddRefed<Promise> SetValue(const nsAString& name, const nsAString& value, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  already_AddRefed<EventHandlerNonNull> GetOnmessage(ErrorResult& aRv, JSCompartment* aCompartment = nullptr) const;

  void SetOnmessage(EventHandlerNonNull* arg, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  static bool
  _Create(JSContext* cx, unsigned argc, JS::Value* vp);
};


} // namespace dom
} // namespace mozilla

#endif // mozilla_dom_EngineeringModeBinding_h
