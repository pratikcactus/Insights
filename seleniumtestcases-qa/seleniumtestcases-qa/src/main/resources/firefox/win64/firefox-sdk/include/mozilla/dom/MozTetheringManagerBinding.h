/* THIS FILE IS AUTOGENERATED FROM MozTetheringManager.webidl BY Codegen.py - DO NOT EDIT */

#ifndef mozilla_dom_MozTetheringManagerBinding_h
#define mozilla_dom_MozTetheringManagerBinding_h

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

class MozTetheringManager;
struct MozTetheringManagerAtoms;
struct NativePropertyHooks;
class Promise;
class ProtoAndIfaceCache;
struct TetheringConfiguration;
struct TetheringConfigurationAtoms;
struct WifiTetheringConfig;
struct WifiTetheringConfigAtoms;

} // namespace dom
} // namespace mozilla

namespace mozilla {
namespace dom {

enum class TetheringType : uint32_t {
  Bluetooth,
  Usb,
  Wifi,
  EndGuard_
};

namespace TetheringTypeValues {
extern const EnumEntry strings[4];
} // namespace TetheringTypeValues

bool
ToJSValue(JSContext* aCx, TetheringType aArgument, JS::MutableHandle<JS::Value> aValue);


enum class SecurityType : uint32_t {
  Open,
  Wpa_psk,
  Wpa2_psk,
  EndGuard_
};

namespace SecurityTypeValues {
extern const EnumEntry strings[4];
} // namespace SecurityTypeValues

bool
ToJSValue(JSContext* aCx, SecurityType aArgument, JS::MutableHandle<JS::Value> aValue);


struct WifiTetheringConfig : public DictionaryBase
{
  Optional<nsString> mKey;
  Optional<SecurityType> mSecurity;
  Optional<nsString> mSsid;

  WifiTetheringConfig();

  explicit inline WifiTetheringConfig(const FastDictionaryInitializer& )
  {
    // Do nothing here; this is used by our "Fast" subclass
  }

  explicit inline WifiTetheringConfig(const WifiTetheringConfig& aOther)
  {
    *this = aOther;
  }

  bool
  Init(JSContext* cx, JS::Handle<JS::Value> val, const char* sourceDescription = "Value", bool passedToJSImpl = false);

  bool
  Init(const nsAString& aJSON);

  bool
  ToObjectInternal(JSContext* cx, JS::MutableHandle<JS::Value> rval) const;

  bool
  ToJSON(nsAString& aJSON) const;

  void
  TraceDictionary(JSTracer* trc);

  void
  operator=(const WifiTetheringConfig& aOther);

private:
  static bool
  InitIds(JSContext* cx, WifiTetheringConfigAtoms* atomsCache);
};

namespace binding_detail {
struct FastWifiTetheringConfig : public WifiTetheringConfig
{
  inline FastWifiTetheringConfig()
    : WifiTetheringConfig(FastDictionaryInitializer())
  {
    // Doesn't matter what int we pass to the parent constructor
  }
};
} // namespace binding_detail


struct TetheringConfiguration : public DictionaryBase
{
  Optional<nsString> mDns1;
  Optional<nsString> mDns2;
  Optional<nsString> mEndIp;
  Optional<nsString> mIp;
  Optional<nsString> mPrefix;
  Optional<nsString> mStartIp;
  WifiTetheringConfig mWifiConfig;

  TetheringConfiguration();

  explicit inline TetheringConfiguration(const FastDictionaryInitializer& )
    : mWifiConfig(FastDictionaryInitializer())
  {
    // Do nothing here; this is used by our "Fast" subclass
  }

  explicit inline TetheringConfiguration(const TetheringConfiguration& aOther)
    : mWifiConfig(FastDictionaryInitializer())
  {
    *this = aOther;
  }

  bool
  Init(JSContext* cx, JS::Handle<JS::Value> val, const char* sourceDescription = "Value", bool passedToJSImpl = false);

  bool
  Init(const nsAString& aJSON);

  bool
  ToObjectInternal(JSContext* cx, JS::MutableHandle<JS::Value> rval) const;

  bool
  ToJSON(nsAString& aJSON) const;

  void
  TraceDictionary(JSTracer* trc);

  void
  operator=(const TetheringConfiguration& aOther);

private:
  static bool
  InitIds(JSContext* cx, TetheringConfigurationAtoms* atomsCache);
};

namespace binding_detail {
struct FastTetheringConfiguration : public TetheringConfiguration
{
  inline FastTetheringConfiguration()
    : TetheringConfiguration(FastDictionaryInitializer())
  {
    // Doesn't matter what int we pass to the parent constructor
  }
};
} // namespace binding_detail


namespace MozTetheringManagerBinding {

  typedef mozilla::dom::MozTetheringManager NativeType;

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
  Wrap(JSContext* aCx, mozilla::dom::MozTetheringManager* aObject, nsWrapperCache* aCache, JS::Handle<JSObject*> aGivenProto, JS::MutableHandle<JSObject*> aReflector);

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

} // namespace MozTetheringManagerBinding



class MozTetheringManagerJSImpl : public CallbackInterface
{
public:
  explicit inline MozTetheringManagerJSImpl(JSContext* aCx, JS::Handle<JSObject*> aCallback, nsIGlobalObject* aIncumbentGlobal)
    : CallbackInterface(aCx, aCallback, aIncumbentGlobal)
  {
  }

  already_AddRefed<Promise> SetTetheringEnabled(bool enabled, TetheringType type, const TetheringConfiguration& config, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  inline bool
  operator==(const MozTetheringManagerJSImpl& aOther) const
  {
    return CallbackInterface::operator==(aOther);
  }

private:
  static bool
  InitIds(JSContext* cx, MozTetheringManagerAtoms* atomsCache);
};


class MozTetheringManager final : public nsSupportsWeakReference,
                                  public nsWrapperCache
{
public:
  NS_DECL_CYCLE_COLLECTING_ISUPPORTS
  NS_DECL_CYCLE_COLLECTION_SCRIPT_HOLDER_CLASS(MozTetheringManager)

private:
  RefPtr<MozTetheringManagerJSImpl> mImpl;
  nsCOMPtr<nsISupports> mParent;

public:
  MozTetheringManager(JS::Handle<JSObject*> aJSImplObject, nsIGlobalObject* aParent);

private:
  ~MozTetheringManager();

public:
  nsISupports* GetParentObject() const;

  virtual JSObject* WrapObject(JSContext* aCx, JS::Handle<JSObject*> aGivenProto) override;

  // Return a raw pointer here to avoid refcounting, but make sure it's safe (the object should be kept alive by the callee).
  already_AddRefed<Promise> SetTetheringEnabled(bool enabled, TetheringType type, const TetheringConfiguration& config, ErrorResult& aRv, JSCompartment* aCompartment = nullptr);

  static bool
  _Create(JSContext* cx, unsigned argc, JS::Value* vp);
};


} // namespace dom
} // namespace mozilla

#endif // mozilla_dom_MozTetheringManagerBinding_h
