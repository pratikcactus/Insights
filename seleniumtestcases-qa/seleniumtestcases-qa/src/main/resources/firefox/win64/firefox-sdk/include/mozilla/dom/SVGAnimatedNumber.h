/* -*- Mode: C++; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 2 -*- */
/* vim: set ts=8 sts=2 et sw=2 tw=80: */
/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

#ifndef mozilla_dom_SVGAnimatedNumber_h
#define mozilla_dom_SVGAnimatedNumber_h

#include "nsISupports.h"
#include "nsWrapperCache.h"

#include "nsSVGElement.h"

namespace mozilla {
namespace dom {

class SVGAnimatedNumber : public nsISupports
                        , public nsWrapperCache
{
public:
  NS_DECL_CYCLE_COLLECTING_ISUPPORTS
  NS_DECL_CYCLE_COLLECTION_SCRIPT_HOLDER_CLASS(SVGAnimatedNumber)

  nsSVGElement* GetParentObject() const
  {
    return mSVGElement;
  }

  virtual JSObject* WrapObject(JSContext* aCx, JS::Handle<JSObject*> aGivenProto)
    override final;

  virtual float BaseVal() = 0;
  virtual void SetBaseVal(float aBaseVal) = 0;
  virtual float AnimVal() = 0;

protected:
  explicit SVGAnimatedNumber(nsSVGElement* aSVGElement)
    : mSVGElement(aSVGElement)
  {
  }
  virtual ~SVGAnimatedNumber() {};

  RefPtr<nsSVGElement> mSVGElement;
};

} // namespace dom
} // namespace mozilla

#endif // mozilla_dom_SVGAnimatedNumber_h
